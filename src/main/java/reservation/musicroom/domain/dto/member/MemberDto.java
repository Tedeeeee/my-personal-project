package reservation.musicroom.domain.dto.member;

import lombok.Builder;
import lombok.Data;
import reservation.musicroom.domain.Entity.Member;
import reservation.musicroom.domain.Entity.Role;

@Data
@Builder
public class MemberDto {
    private String MemberEmail;
    private String MemberPassword;
    private String MemberCheckPassword;

    public Member toMember(MemberDto memberDto) {
        return Member.builder()
                .MemberEmail(memberDto.getMemberEmail())
                .MemberPassword(memberDto.getMemberPassword())
                .MemberRole(Role.ROLE_MEMBER)
                .build();
    }

    public Member toOwner(MemberDto memberDto) {
        return Member.builder()
                .MemberEmail(memberDto.getMemberEmail())
                .MemberPassword(memberDto.getMemberPassword())
                .MemberRole(Role.ROLE_OWNER)
                .build();
    }
}
