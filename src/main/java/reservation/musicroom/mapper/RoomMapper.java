package reservation.musicroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import reservation.musicroom.domain.Entity.Room;

@Mapper
public interface RoomMapper {
    int createRoom(Room room);
}
