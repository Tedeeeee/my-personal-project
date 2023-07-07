package reservation.musicroom.domain.dto.roomDetail;

import lombok.Data;

@Data
public class ChangeRoomDetailDto {
    private String exRoomDetailName;
    private String newRoomDetailName;
    private String roomLocation;
    private String newRoomDetailSize;
    private String newRoomDetailTimePrice;
    private String newRoomDetailMonthPrice;
}
