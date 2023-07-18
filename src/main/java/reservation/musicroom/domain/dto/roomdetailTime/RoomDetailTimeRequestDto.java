package reservation.musicroom.domain.dto.roomdetailTime;

import lombok.Data;
import reservation.musicroom.domain.Entity.RoomDetailTime;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;

@Data
public class RoomDetailTimeRequestDto {

    private Long roomDetailId;
    private String roomLocation;
    private String roomDetailName;
    private String useYear;
    private String useMonth;
    private String startDay;
    private String endDay;
    private String startTime;
    private String endTime;

    public RoomDetailTime toRoomDetailTime(RoomDetailTimeRequestDto roomDetailTimeRequestDto) {
        return RoomDetailTime.builder()
                .roomDetailId(roomDetailTimeRequestDto.getRoomDetailId())
                .roomDetailName(roomDetailTimeRequestDto.getRoomDetailName())
                .roomDetailTimeStartDay(roomDetailTimeRequestDto.getStartDay())
                .roomDetailTimeEndDay(roomDetailTimeRequestDto.getEndDay())
                .roomDetailTimeStartTime(roomDetailTimeRequestDto.getStartTime())
                .roomDetailTimeEndTime(roomDetailTimeRequestDto.getEndTime())
                .build();
    }

}
