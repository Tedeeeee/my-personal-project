package reservation.musicroom.domain.dto.roomDetail;

import lombok.Data;
import reservation.musicroom.domain.Entity.RoomDetail;

@Data
public class RoomDetailRequestDto {
    private String roomName;
    private String roomFloor;
    private String roomDetailName;
    private String roomDetailPhoto;
    private String roomDetailFacilities;

    public RoomDetail toRoomDetail(RoomDetailRequestDto requestDto) {
        return RoomDetail.builder()
                .roomName(requestDto.roomName)
                .roomFloor(requestDto.roomFloor)
                .roomDetailName(requestDto.roomDetailName)
                .roomDetailPhoto(requestDto.roomDetailPhoto)
                .roomDetailFacilities(requestDto.roomDetailFacilities)
                .build();
    }
}
