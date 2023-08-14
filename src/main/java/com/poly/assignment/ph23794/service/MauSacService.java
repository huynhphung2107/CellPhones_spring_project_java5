package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.dto.request.MauSacRequest;
import com.poly.assignment.ph23794.entity.MauSac;
import com.poly.assignment.ph23794.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MauSacService {

    Page<MauSac> getAll(Integer pageNo, Integer pageSizr);

    void add(MauSacRequest request);

    void update(MauSacRequest request);

    void remove(String id);

    MauSac getOne(String id);

    List<MauSac> getAll1();

}
