package reservation.musicroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;

import java.util.List;

@Mapper
public interface RoomDetailMapper {

    int registerRoomDetail(RoomDetailRequestDto roomDetailRequestDto);

    List<RoomDetailResponseDto> findRoomDetail(@Param("roomName") String roomName, @Param("roomFloor") String roomFloor);
}
