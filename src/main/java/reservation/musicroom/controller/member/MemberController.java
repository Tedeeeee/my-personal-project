package reservation.musicroom.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reservation.musicroom.domain.dto.MemberDto;
import reservation.musicroom.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 내 프로필
    @GetMapping("/mypage")
    public String myPage() {
        return "myProfile";
    }

    // 회원가입 홈페이지 불러오는곳
    @GetMapping("/signupPage")
    public String signUp() {
        return "fragment/signupPage";
    }

    // 회원가입 하는곳
    @PostMapping("/signUp")
    public String createMember(MemberDto memberDto) {
        memberService.createMember(memberDto);
        return "redirect:/";
    }
}
