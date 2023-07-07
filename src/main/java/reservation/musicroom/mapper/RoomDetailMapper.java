package reservation.musicroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import reservation.musicroom.domain.Entity.RoomDetail;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;

import java.util.List;

@Mapper
public interface RoomDetailMapper {

    int registerRoomDetail(RoomDetail roomDetail);

    List<RoomDetailResponseDto> findRoomDetail(@Param("roomLocation") String roomLocation, @Param("roomFloor") String roomFloor);

    RoomDetailResponseDto findRoomDetailByRoomNum(@Param("roomDetailName") String roomDetailName, @Param("roomLocation") String roomLocation);

    int optionChange(@Param("roomDetailName") String roomDetailName, @Param("roomLocation") String roomLocation, @Param("roomDetailFacilities") String roomDetailFacilities);

    int nameChange(@Param("exRoomDetailName") String exRoomDetailName, @Param("roomLocation") String roomLocation, @Param("newRoomDetailName")String newRoomDetailName);
    int sizeChange(@Param("exRoomDetailName") String exRoomDetailName, @Param("roomLocation") String roomLocation, @Param("newRoomDetailSize")String newRoomDetailSize);
    int timePriceChange(@Param("exRoomDetailName") String exRoomDetailName, @Param("roomLocation") String roomLocation, @Param("newRoomDetailTimePrice")String newRoomDetailTimePrice);
    int monthPriceChange(@Param("exRoomDetailName") String exRoomDetailName, @Param("roomLocation") String roomLocation, @Param("newRoomDetailMonthPrice")String newRoomDetailMonthPrice);
}
