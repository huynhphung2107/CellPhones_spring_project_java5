package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.dto.request.DongSpRequest;
import com.poly.assignment.ph23794.entity.DongSp;
import com.poly.assignment.ph23794.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DongSpService {

    Page<DongSp> getAll(Integer pageNo, Integer pageSizr);

    void add(DongSpRequest request);

    void update(DongSpRequest request);

    void remove(String id);

    DongSp getOne(String id);

    List<DongSp> getAll1();


}
