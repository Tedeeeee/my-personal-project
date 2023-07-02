package reservation.musicroom.controller.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reservation.musicroom.domain.Entity.Member;
import reservation.musicroom.service.MemberService;
import reservation.musicroom.utils.SecurityUtil;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final SecurityUtil securityUtil;

    // 로그인 페이지 불러오는곳
    @GetMapping("/loginPage")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception, Model model) {

        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "fragment/loginPage";
    }

    // 로그아웃 하는곳
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/loginPage";
    }

    @GetMapping("/denied")
    public String accessDenied(@RequestParam(value = "exception", required = false) String exception, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Member member = (Member) authentication.getPrincipal();

        model.addAttribute("username", member.getMemberEmail());
        model.addAttribute("exception", exception);

        return "/fragment/denied";
    }
}
