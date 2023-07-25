package reservation.musicroom.domain.dto.roomDetail;

import lombok.Data;
import reservation.musicroom.domain.Entity.RoomDetail;

@Data
public class RoomDetailRequestDto {
    private String roomFloor;
    private String roomLocation;
    private String roomDetailName;
    private String roomDetailPhoto;
    private String roomDetailFacilities;
    private Long roomCount;

    public RoomDetail toRoomDetail(RoomDetailRequestDto requestDto) {
        return RoomDetail.builder()
                .roomLocation(requestDto.getRoomLocation())
                .roomFloor(requestDto.getRoomFloor())
                .roomDetailName(requestDto.getRoomDetailName())
                .roomDetailPhoto(requestDto.getRoomDetailPhoto())
                .roomDetailFacilities(requestDto.getRoomDetailFacilities())
                .build();
    }
}
