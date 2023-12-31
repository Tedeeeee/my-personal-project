package reservation.musicroom.domain.dto.roomDetail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDetailResponseDto {
    private String roomLocation;
    private String roomFloor;
    private Long roomDetailId;
    private String roomDetailName;
    private String roomDetailPhoto;
    private String roomDetailFacilities;
    private String roomDetailTimePrice;
    private String roomDetailMonthPrice;
    private String roomDetailSize;
}
