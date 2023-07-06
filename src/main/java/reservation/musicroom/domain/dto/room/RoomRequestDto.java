package reservation.musicroom.domain.dto.room;

import lombok.*;
import reservation.musicroom.domain.Entity.Room;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;

import java.util.List;

@Data
public class RoomRequestDto {
    private String memberEmail;
    private String roomName;
    private String roomLocation;
    private String roomLocationDetail;
    private String roomExplanation;
    private String roomFloor;
    private String roomFacilities;
    private String roomCount;

    public Room toRoom(RoomRequestDto requestDto) {
        return Room.builder()
                .memberEmail(requestDto.getMemberEmail())
                .roomName(requestDto.getRoomName())
                .roomLocation(requestDto.getRoomLocation())
                .roomLocationDetail(requestDto.getRoomLocationDetail())
                .roomExplanation(requestDto.getRoomExplanation())
                .roomFloor(requestDto.getRoomFloor())
                .roomFacilities(requestDto.getRoomFacilities())
                .roomCount(requestDto.getRoomCount())
                .build();
    }
}
