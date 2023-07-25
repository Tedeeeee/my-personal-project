package reservation.musicroom.domain.Entity;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Room {
    private String memberEmail;
    private String roomName;
    private String roomLocation;
    private String roomCity;
    private String roomLocationDetail;
    private String roomExplanation;
    private String roomFloor;
    private String roomFacilities;
    private String roomCount;
}
