package reservation.musicroom.domain.dto.member;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class MemberResponseDto {

    private String memberEmail;
    private String memberInstagram;
    private String memberPhone;
    private String memberHomePage;
}
