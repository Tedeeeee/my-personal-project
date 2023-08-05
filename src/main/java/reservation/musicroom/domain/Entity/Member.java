package reservation.musicroom.domain.Entity;

import lombok.*;
import reservation.musicroom.domain.dto.member.MemberResponseDto;
import reservation.musicroom.domain.dto.room.RoomRequestDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {

    private Long memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberRole;
    private String memberInstagram;
    private String memberPhone;
    private String memberHomePage;
    private String memberState;

    public MemberResponseDto toMemberResponse(Member member) {
        return MemberResponseDto.builder()
                .memberEmail(member.getMemberEmail())
                .memberInstagram(member.getMemberInstagram())
                .memberPhone(member.getMemberPhone())
                .memberHomePage(member.getMemberHomePage())
                .memberRole(member.getMemberRole())
                .build();
    }
}
