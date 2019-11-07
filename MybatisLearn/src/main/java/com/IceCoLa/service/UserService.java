package com.IceCoLa.service;

import com.IceCoLa.domain.PageInfo;

import java.io.IOException;

public interface UserService {
    PageInfo showPage(int pageSize, int pageNumber) throws IOException;
}
