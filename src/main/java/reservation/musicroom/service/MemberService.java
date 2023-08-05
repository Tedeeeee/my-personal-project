package reservation.musicroom.service;

import reservation.musicroom.domain.dto.member.MemberRequestDto;
import reservation.musicroom.domain.dto.member.MemberResponseDto;


public interface MemberService {

    MemberResponseDto findByEmail();

    int signUp(MemberRequestDto memberRequestDto) throws Exception;
}
