package reservation.musicroom.domain.dto.member;

import lombok.Builder;
import lombok.Data;
import reservation.musicroom.domain.Entity.Member;

@Data
@Builder
public class MemberRequestDto {
    private String memberEmail;
    private String memberPassword;
    private String memberInstagram;
    private String memberPhone;
    private String memberHomePage;
    private String memberState;

    public Member toMember(MemberRequestDto memberRequestDto) {
        return Member.builder()
                .memberEmail(memberRequestDto.getMemberEmail())
                .memberPassword(memberRequestDto.getMemberPassword())
                .memberRole("MEMBER")
                .memberState("T")
                .build();
    }

    public Member toOwner(MemberRequestDto memberRequestDto) {
        return Member.builder()
                .memberEmail(memberRequestDto.getMemberEmail())
                .memberPassword(memberRequestDto.getMemberPassword())
                .memberRole("OWNER")
                .memberState("T")
                .build();
    }
}
