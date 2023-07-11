package reservation.musicroom.domain.dto.member;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class MemberResponseDto {

    private String MemberEmail;
    private String MemberInstagram;
    private String MemberPhone;
    private String MemberHomePage;
}
