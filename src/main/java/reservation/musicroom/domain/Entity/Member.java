package reservation.musicroom.domain.Entity;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {

    private Long Id;
    private String MemberEmail;
    private String MemberPassword;
    private Role MemberRole;
}
