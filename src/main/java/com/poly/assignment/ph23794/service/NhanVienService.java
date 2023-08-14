package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.dto.request.NhanVienRequest;
import com.poly.assignment.ph23794.dto.response.NhanVienResponse;
import com.poly.assignment.ph23794.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {

    Page<NhanVienResponse> getAll(Integer pageNo, Integer pageSize);

    void add(NhanVienRequest request);

    void update(NhanVienRequest request);

    void remove(String id);

    NhanVien getOne(String id);

    List<NhanVien> getAll1();


}
