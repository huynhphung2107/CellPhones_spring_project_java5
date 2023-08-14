package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.dto.request.ChiTietSanPhamRequest;
import com.poly.assignment.ph23794.dto.response.ChiTietSanPhamResponse;
import com.poly.assignment.ph23794.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChiTietSanPhamService {

    Page<ChiTietSanPhamResponse> getAll(Integer pageNo, Integer pageSizr);

    void add(ChiTietSanPhamRequest request);

    void update(ChiTietSanPhamRequest request);

    void remove(String id);

    ChiTietSanPham getOne(String id);

    List<ChiTietSanPham> getAll1();

}
