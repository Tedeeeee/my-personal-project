package reservation.musicroom.domain.dto.roomDetail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDetailResponseDto {
    private String roomDetailName;
    private String roomDetailPhoto;
    private String roomDetailFacilities;

}
