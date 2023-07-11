package reservation.musicroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reservation.musicroom.domain.dto.member.MemberResponseDto;
import reservation.musicroom.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/findByEmail")
    public ResponseEntity<MemberResponseDto> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(memberService.findByEmail(email));
    }
}
