package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.dto.request.NoiSanXuatRequest;
import com.poly.assignment.ph23794.entity.NoiSanXuat;
import com.poly.assignment.ph23794.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NoiSanXuatService {

    Page<NoiSanXuat> getAll(Integer pageNo, Integer pageSizr);

    void add(NoiSanXuatRequest request);

    void update(NoiSanXuatRequest request);

    void remove(String id);

    NoiSanXuat getOne(String id);

    List<NoiSanXuat> getAll1();
}
