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
    private String roomDetailState;

    public RoomDetail toRoomDetail(RoomDetailRequestDto requestDto) {
        return RoomDetail.builder()
                .roomLocation(requestDto.roomLocation)
                .roomFloor(requestDto.roomFloor)
                .roomDetailName(requestDto.roomDetailName)
                .roomDetailPhoto(requestDto.roomDetailPhoto)
                .roomDetailFacilities(requestDto.roomDetailFacilities)
                .roomDetailState(requestDto.roomDetailState)
                .build();
    }
}
