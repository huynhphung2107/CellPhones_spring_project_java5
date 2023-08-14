package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.dto.request.KhachHangRequest;
import com.poly.assignment.ph23794.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhachHangService {

    Page<KhachHang> getAll(Integer pageNo, Integer pageSizr);

    void add(KhachHangRequest request);

    void update(KhachHangRequest request);

    void remove(String id);

    KhachHang getOne(String id);

    List<KhachHang> getAll1();

}
