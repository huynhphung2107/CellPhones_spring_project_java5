package com.poly.assignment.ph23794.service.impl;

import com.poly.assignment.ph23794.dto.request.ChucVuRequest;
import com.poly.assignment.ph23794.entity.ChucVu;
import com.poly.assignment.ph23794.repository.ChucVuRepository;
import com.poly.assignment.ph23794.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository ChucVuRepository;

    @Autowired
    private ChucVuRepository ChucVuService;

    @Override
    public Page<ChucVu> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return ChucVuRepository.findAll(pageable);
    }

    @Override
    public void add(ChucVuRequest request) {
        ChucVu sp = ChucVu.builder()
                .ma(request.getMa())
                .ten(request.getTen())
                .build();
        ChucVuRepository.save(sp);

    }

    @Override
    public void update(ChucVuRequest request) {
        ChucVu sp = ChucVuService.getOne(request.getId());
        sp.setMa(request.getMa());
        sp.setTen(request.getTen());

        ChucVuRepository.save(sp);


    }

    @Override
    public void remove(String id) {
        ChucVuRepository.deleteById(id);

    }

    @Override
    public ChucVu getOne(String id) {
        return ChucVuRepository.findById(id).get();
    }

    @Override
    public List<ChucVu> getAll1() {
        return ChucVuRepository.findAll();
    }

}
