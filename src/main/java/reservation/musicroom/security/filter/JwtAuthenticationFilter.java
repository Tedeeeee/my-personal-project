package reservation.musicroom.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import reservation.musicroom.domain.Entity.Member;
import reservation.musicroom.mapper.MemberMapper;
import reservation.musicroom.utils.TokenUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SignatureException;
import java.util.*;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final TokenUtil tokenUtil;
    private final MemberMapper memberMapper;
    private final GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();

    private static final List<String> EXCLUDE_URL = Collections.unmodifiableList(Arrays.asList(
            "/login", "/member/signUp", "/room/findAllRoom"
    ));
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader("Authorization");

        try {
            if (header != null && !header.equalsIgnoreCase("")) {

                String token = TokenUtil.getTokenFromHeader(header);

                if (tokenUtil.isValidToken(token)) {

                    String memberId = tokenUtil.getMemberIdFromToken(token);

                    if (memberId != null && !memberId.equalsIgnoreCase("")) {
                        int memberSq = Integer.parseInt(memberId);
                        saveAuthentication(memberSq);
                        filterChain.doFilter(request, response);
                    } else {
                        throw new RuntimeException("토큰 1번 에러 발생");
                    }
                } else {
                    throw new RuntimeException("토큰 2번 에러 발생");
                }
            } else {
                throw new RuntimeException("토큰 3번 에러 발생");
            }
        } catch (Exception e) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/josn");
            PrintWriter printWriter = response.getWriter();
            JSONObject jsonObject = jsonResponseWrapper(e);
            printWriter.print(jsonObject);
            printWriter.flush();
            printWriter.close();
        }
    }

    private JSONObject jsonResponseWrapper(Exception e) {
        String resultMsg = "";

        if (e instanceof ExpiredJwtException) {
            resultMsg = "토큰이 만료되었습니다";
        } else if (e instanceof SignatureException) {
            resultMsg = "서명이 없습니다";
        } else if (e instanceof JwtException) {
            resultMsg = "토큰에 문제가 생겼습니다";
        } else {
            resultMsg = "알수없는 문제가 생겼습니다";
        }

        HashMap<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("status", 401);
        jsonMap.put("code", 9999);
        jsonMap.put("message", resultMsg);
        jsonMap.put("reason", e.getMessage());
        return new JSONObject(jsonMap);
    }

    public void saveAuthentication(int memberSq) {
        Member member = memberMapper.findBySq(memberSq);

        UserDetails userDetails = User.builder()
                .username(member.getMemberEmail())
                .password(member.getMemberPassword())
                .roles(member.getMemberRole())
                .build();


        Authentication authentication = new UsernamePasswordAuthenticationToken(member.getMemberEmail(), null,
                authoritiesMapper.mapAuthorities(userDetails.getAuthorities()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return EXCLUDE_URL.stream().anyMatch(exclude -> exclude.equalsIgnoreCase(request.getServletPath()));
    }
}
