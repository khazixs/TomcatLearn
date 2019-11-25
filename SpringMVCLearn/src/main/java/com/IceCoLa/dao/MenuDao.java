package com.IceCoLa.dao;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import com.IceCoLa.pojo.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuDao")
public interface MenuDao {
    List<Menu> selByPid(@Param("pid") int pid);
}
