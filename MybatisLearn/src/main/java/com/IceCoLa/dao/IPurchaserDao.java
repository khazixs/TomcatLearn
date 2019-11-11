package com.IceCoLa.dao;

import com.IceCoLa.domain.Purchaser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPurchaserDao {
    List<Purchaser> selectAll();

    @Select("select name from purchaser where id = #{id}")
    String selectByName(Integer id);
}
