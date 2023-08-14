package com.poly.assignment.ph23794.service.impl;

import com.poly.assignment.ph23794.dto.request.DongSpRequest;
import com.poly.assignment.ph23794.entity.DongSp;
import com.poly.assignment.ph23794.repository.DongSpRepository;
import com.poly.assignment.ph23794.service.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DongSpServiceImpl implements DongSpService {

    @Autowired
    private DongSpRepository DongSpRepository;

    @Autowired
    private DongSpRepository DongSpService;

    @Override
    public Page<DongSp> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return DongSpRepository.findAll(pageable);
    }

    @Override
    public void add(DongSpRequest request) {
        DongSp sp = DongSp.builder()
                .ma(request.getMa())
                .ten(request.getTen())
                .build();
        DongSpRepository.save(sp);

    }

    @Override
    public void update(DongSpRequest request) {
        DongSp sp = DongSpService.getOne(request.getId());
        sp.setMa(request.getMa());
        sp.setTen(request.getTen());

        DongSpRepository.save(sp);


    }

    @Override
    public void remove(String id) {
        DongSpRepository.deleteById(id);

    }

    @Override
    public DongSp getOne(String id) {
        return DongSpRepository.findById(id).get();
    }

    @Override
    public List<DongSp> getAll1() {
        return DongSpRepository.findAll();
    }

}
