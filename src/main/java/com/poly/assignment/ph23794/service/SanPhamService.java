package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.dto.request.SanPhamRequest;
import com.poly.assignment.ph23794.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll1();

    Page<SanPham> getAll(Integer pageNo, Integer pageSize);

    void add(SanPhamRequest request);

    void update(SanPhamRequest request);

    void remove(String id);

    SanPham getOne(String id);

    File saveFile(MultipartFile file, String path);
}
