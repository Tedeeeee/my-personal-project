package reservation.musicroom.domain.dto.roomdetailTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDetailTimeDto {
    private String roomDetailName;
    private String roomDetailTimeStartDay;
    private String roomDetailTimeEndDay;
    private String roomDetailTimeStartTime;
    private String roomDetailTimeEndTime;
}
