package reservation.musicroom.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import reservation.musicroom.domain.Entity.RoomDetailTime;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeDto;

import java.util.List;

@Mapper
public interface RoomDetailTimeMapper {

    int reservationRoom(RoomDetailTime roomDetailTime);
    List<RoomDetailTimeDto> findRoomDetailTime(Long roomDetailId);


}
