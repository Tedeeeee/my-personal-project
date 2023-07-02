package reservation.musicroom.controller.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import reservation.musicroom.domain.dto.MemberDto;
import reservation.musicroom.service.MemberService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public String createMember(MemberDto memberDto) {
        memberService.createMember(memberDto);
        return "redirect:/";
    }
}
