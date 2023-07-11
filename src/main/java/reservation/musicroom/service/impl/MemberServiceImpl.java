package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.Entity.Member;
import reservation.musicroom.domain.dto.member.MemberResponseDto;
import reservation.musicroom.mapper.MemberMapper;
import reservation.musicroom.service.MemberService;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;


    @Override
    public MemberResponseDto findByEmail(String memberEmail) {
        // 멤버 존재 확인

        Member member = memberMapper.findByEmail(memberEmail);
        return member.toMemberResponse(member);
    }
}
