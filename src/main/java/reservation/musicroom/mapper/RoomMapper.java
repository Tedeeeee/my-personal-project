package reservation.musicroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import reservation.musicroom.domain.Entity.Room;
import reservation.musicroom.domain.dto.room.RoomRequestDto;
import reservation.musicroom.domain.dto.room.RoomResponseDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;

import java.util.List;

@Mapper
public interface RoomMapper {
    int createRoom(Room room);

    List<RoomResponseDto> getAllRoomByCity(String roomCity);
    List<RoomResponseDto> getAllRoom(String memberEmail);
    List<RoomResponseDto> findAllRoom();
    RoomResponseDto ownerRoomDetail(String roomLocation);
    RoomResponseDto getMyRoom(@Param("roomName") String roomName,@Param("roomLocation") String roomLocation);
}
