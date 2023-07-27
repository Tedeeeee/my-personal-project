package reservation.musicroom.utill;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

@Log4j2
@Component
public class TokenUtil {

    @Value("${jwt.security.key}")
    private String secretKey;

    private static final String ACCESS_TOKEN_SUBJECT = "AccessToken";

    // accessToken 생성 클레임에 너무 많은 정보를 두고 싶지 않기 때문에
    // 사용자의 시퀀스 번호로 확인을 진행할 것이다.
    public String createAccessToken(Long memberId) {
        JwtBuilder builder = Jwts.builder()
                .setHeader(createHeader())
                .setClaims(createClaims(memberId))
                .setSubject(ACCESS_TOKEN_SUBJECT)
                .setExpiration(createAccessTokenExpiredDate())
                .signWith(createSignature(), SignatureAlgorithm.HS256);
        return builder.compact();
    }

    // accessToken 의 만료기간 (6시간) 을 설정
    private static Date createAccessTokenExpiredDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, 6);
        return c.getTime();
    }

    // refreshToken 의 만료기간 (7일) 을 설정
    private static Date createRefreshTokenExpiredDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 7);
        return c.getTime();
    }

    // 해당 토큰의 헤더 설정을 하는 곳이다.
    private static Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();

        header.put("typ", "JWT");
        header.put("alg", "HS256");
        return header;
    }

    // 토큰에 들어갈 사용자의 정보이다.
    private static Map<String, Long> createClaims(Long memberId) {
        Map<String, Long> claims = new HashMap<>();

        claims.put("memberNum", memberId);
        return claims;
    }

    // Signature 에 사용할 Key 를 설정
    private Key createSignature() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
