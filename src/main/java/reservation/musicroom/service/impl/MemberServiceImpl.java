package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.Entity.Member;
import reservation.musicroom.domain.dto.MemberDto;
import reservation.musicroom.mapper.MemberMapper;
import reservation.musicroom.service.MemberService;

@Service("MemberService")
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void createMember(MemberDto memberDto) {
        memberDto.setMemberPassword(passwordEncoder.encode(memberDto.getMemberPassword()));
        Member member = memberDto.toMember(memberDto);
        memberMapper.save(member);
    }
}
