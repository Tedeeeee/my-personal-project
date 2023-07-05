package reservation.musicroom.domain.dto.room;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomResponseDto {
    private String roomName;
    private String roomLocation;
    private String roomLocationDetail;
    private String roomExplanation;
    private String roomFloor;
    private String roomFacilities;
}
