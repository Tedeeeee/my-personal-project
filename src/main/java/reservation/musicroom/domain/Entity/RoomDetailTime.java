package reservation.musicroom.domain.Entity;

import lombok.*;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RoomDetailTime {

    private Long roomDetailId;
    private String roomDetailName;
    private String roomDetailTimeStartDay;
    private String roomDetailTimeEndDay;
    private String roomDetailTimeStartTime;
    private String roomDetailTimeEndTime;

    public RoomDetailTimeDto toRoomDetailTime(RoomDetailTime roomDetailTime) {
       return RoomDetailTimeDto.builder()
               .roomDetailName(roomDetailTime.getRoomDetailName())
               .roomDetailTimeStartDay(roomDetailTime.getRoomDetailTimeStartDay())
               .roomDetailTimeEndDay(roomDetailTime.getRoomDetailTimeEndDay())
               .roomDetailTimeStartTime(roomDetailTime.getRoomDetailTimeStartTime())
               .roomDetailTimeEndTime(roomDetailTime.getRoomDetailTimeEndTime())
               .build();
    }
}
