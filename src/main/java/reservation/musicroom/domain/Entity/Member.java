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

    private String MemberEmail;
    private String MemberPassword;
    private Role MemberRole;
    private String MemberInstagram;
    private String MemberPhone;
    private String MemberHomePage;

    public MemberResponseDto toMemberResponse(Member member) {
        return MemberResponseDto.builder()
                .MemberEmail(member.getMemberEmail())
                .MemberInstagram(member.getMemberInstagram())
                .MemberPhone(member.getMemberPhone())
                .MemberHomePage(member.getMemberHomePage())
                .build();
    }
}
