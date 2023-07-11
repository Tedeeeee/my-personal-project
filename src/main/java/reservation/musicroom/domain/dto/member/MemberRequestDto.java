package reservation.musicroom.domain.dto.member;

import lombok.Builder;
import lombok.Data;
import reservation.musicroom.domain.Entity.Member;
import reservation.musicroom.domain.Entity.Role;

@Data
@Builder
public class MemberRequestDto {
    private String MemberEmail;
    private String MemberPassword;
    private String MemberInstagram;
    private String MemberPhone;
    private String MemberHomePage;

    public Member toMember(MemberRequestDto memberRequestDto) {
        return Member.builder()
                .MemberEmail(memberRequestDto.getMemberEmail())
                .MemberPassword(memberRequestDto.getMemberPassword())
                .MemberRole(Role.ROLE_MEMBER)
                .MemberInstagram(memberRequestDto.getMemberInstagram())
                .MemberPhone(memberRequestDto.getMemberPhone())
                .MemberHomePage(memberRequestDto.getMemberHomePage())
                .build();
    }

    public Member toOwner(MemberRequestDto memberRequestDto) {
        return Member.builder()
                .MemberEmail(memberRequestDto.getMemberEmail())
                .MemberPassword(memberRequestDto.getMemberPassword())
                .MemberRole(Role.ROLE_OWNER)
                .MemberInstagram(memberRequestDto.getMemberInstagram())
                .MemberPhone(memberRequestDto.getMemberPhone())
                .MemberHomePage(memberRequestDto.getMemberHomePage())
                .build();
    }
}
