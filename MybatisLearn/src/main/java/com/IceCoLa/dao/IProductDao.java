package com.IceCoLa.dao;

import com.IceCoLa.domain.Product;
import org.apache.ibatis.annotations.Param;

public interface IProductDao {
    Product selectById(@Param("id") Integer id);
}
