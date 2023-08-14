package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.dto.request.ChucVuRequest;
import com.poly.assignment.ph23794.entity.ChucVu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChucVuService {

    Page<ChucVu> getAll(Integer pageNo, Integer pageSizr);

    void add(ChucVuRequest request);

    void update(ChucVuRequest request);

    void remove(String id);

    ChucVu getOne(String id);

    List<ChucVu> getAll1();

}
