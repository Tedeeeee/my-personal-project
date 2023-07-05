package reservation.musicroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;

@Mapper
public interface RoomDetailMapper {

    int registerRoomDetail(RoomDetailRequestDto roomDetailRequestDto);
}
