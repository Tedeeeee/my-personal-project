package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.Entity.Member;
import reservation.musicroom.domain.dto.member.MemberRequestDto;
import reservation.musicroom.domain.dto.member.MemberResponseDto;
import reservation.musicroom.mapper.MemberMapper;
import reservation.musicroom.service.MemberService;
import reservation.musicroom.utils.SecurityUtil;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public MemberResponseDto findByEmail() {
        String currentMemberId = SecurityUtil.getCurrentMemberId();

        Member member = memberMapper.findByEmail(currentMemberId);
        return member.toMemberResponse(member);
    }

    @Override
    public int signUp(MemberRequestDto memberRequestDto) throws Exception {
        System.out.println("memberRequestDto = " + memberRequestDto.toString());
        // 사용자의 아이디를 전부 가져와서 확인해야
        if (memberMapper.findByEmail(memberRequestDto.getMemberEmail()) != null) {
            throw new Exception("중복아이디 설정");
        }

        memberRequestDto.setMemberPassword(passwordEncoder.encode(memberRequestDto.getMemberPassword()));
        Member member = memberRequestDto.toMember(memberRequestDto);

        return memberMapper.save(member);
        
    }
}
