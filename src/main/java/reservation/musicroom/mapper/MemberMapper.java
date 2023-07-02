package reservation.musicroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import reservation.musicroom.domain.Entity.Member;

@Mapper
public interface MemberMapper {
    void save(Member member);
}
