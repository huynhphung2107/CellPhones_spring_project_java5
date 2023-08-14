package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.dto.request.CuaHangRequest;
import com.poly.assignment.ph23794.entity.ChucVu;
import com.poly.assignment.ph23794.entity.CuaHang;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CuaHangService {

    Page<CuaHang> getAll(Integer pageNo, Integer pageSizr);

    void add(CuaHangRequest request);

    void update(CuaHangRequest request);

    void remove(String id);

    CuaHang getOne(String id);

    List<CuaHang> getAll1();


}
