package com.poly.assignment.ph23794.service.impl;

import com.poly.assignment.ph23794.dto.request.CuaHangRequest;
import com.poly.assignment.ph23794.entity.CuaHang;
import com.poly.assignment.ph23794.repository.CuaHangRepository;
import com.poly.assignment.ph23794.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    private CuaHangRepository CuaHangRepository;

    @Autowired
    private CuaHangRepository CuaHangService;

    @Override
    public Page<CuaHang> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return CuaHangRepository.findAll(pageable);
    }

    @Override
    public void add(CuaHangRequest request) {
        CuaHang sp = CuaHang.builder()
                .ma(request.getMa())
                .ten(request.getTen())
                .build();
        CuaHangRepository.save(sp);

    }

    @Override
    public void update(CuaHangRequest request) {
        CuaHang sp = CuaHangService.getOne(request.getId());
        sp.setMa(request.getMa());
        sp.setTen(request.getTen());

        CuaHangRepository.save(sp);


    }

    @Override
    public void remove(String id) {
        CuaHangRepository.deleteById(id);

    }

    @Override
    public CuaHang getOne(String id) {
        return CuaHangRepository.findById(id).get();
    }

    @Override
    public List<CuaHang> getAll1() {
        return CuaHangRepository.findAll();
    }

}
