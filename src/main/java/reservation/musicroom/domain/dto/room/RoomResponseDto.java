package reservation.musicroom.domain.dto.room;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RoomResponseDto {
    private String memberEmail;
    private String roomName;
    private String roomLocation;
    private String roomLocationDetail;
    private String roomExplanation;
    private String roomFloor;
    private String roomFacilities;
    private String roomCount;
    private String roomPhoto;
}
