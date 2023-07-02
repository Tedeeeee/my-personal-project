package reservation.musicroom.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMassege = "유효하지 않은 아이디 혹은 비밀번호입니다";

        if (exception instanceof BadCredentialsException) {
            errorMassege = "유효하지 않은 아이디 혹은 비밀번호입니다.";
        } else if (exception instanceof InsufficientAuthenticationException) {
            errorMassege = "SecretKey가 전달되지 않았습니다";
        }

        setDefaultFailureUrl("/login?error=true&exception=" + exception);

        super.onAuthenticationFailure(request, response, exception);


    }
}
