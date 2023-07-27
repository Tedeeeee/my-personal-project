package reservation.musicroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservation.musicroom.domain.dto.member.MemberRequestDto;
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

    @PostMapping("/signUp")
    public ResponseEntity<Integer> signUp(@RequestBody MemberRequestDto memberRequestDto) throws Exception {
        return ResponseEntity.ok(memberService.signUp(memberRequestDto));
    }

}
