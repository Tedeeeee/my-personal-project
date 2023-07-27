package reservation.musicroom.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import reservation.musicroom.domain.Entity.Member;
import reservation.musicroom.mapper.MemberMapper;
import reservation.musicroom.utill.TokenUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final TokenUtil tokenUtil;
    private final MemberMapper memberMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // 오로지 토큰만 전달할 예정이다.
        Member mm = (Member) authentication.getPrincipal();
        Member member = memberMapper.findByEmail(mm.getMemberEmail());

        // ID 값으로 accessToken 생성
        String accessToken = tokenUtil.createAccessToken(member.getMemberId());

        // 탈퇴한 회원인지 찾는 과정이 필요하다.
        HashMap<String, Object> responseMap = new HashMap<>();
        JSONObject jsonObject;

        if (member.getMemberState().equals("D")) {
            responseMap.put("resultCode", 9001);
            responseMap.put("failMsg", "휴면 계정입니다.");
        } else {
            responseMap.put("resultCode", 200);
            responseMap.put("AccessToken", accessToken);
        }

        jsonObject = new JSONObject(responseMap);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonObject);
        printWriter.flush();
        printWriter.close();
    }
}
