package com.IceCoLa.service.impl;/*
 * @program: SpringMVCLearn
 * @author: IceCoLa
 */

import com.IceCoLa.dao.MenuDao;
import com.IceCoLa.pojo.Menu;
import com.IceCoLa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;

    @Override
    public List<Menu> show() {
        return menuDao.selByPid(1);
    }
}
