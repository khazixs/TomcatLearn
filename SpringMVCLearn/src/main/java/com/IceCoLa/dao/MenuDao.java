package com.IceCoLa.dao;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import com.IceCoLa.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    List<Menu> selByPid(@Param("pid") int pid);
}
