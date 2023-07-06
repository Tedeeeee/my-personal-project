package reservation.musicroom.domain.Entity;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RoomDetail {
    private String roomName;
    private String roomFloor;
    private String roomDetailName;
    private String roomDetailPhoto;
    private String roomDetailFacilities;
    private String roomDetailState;
}
