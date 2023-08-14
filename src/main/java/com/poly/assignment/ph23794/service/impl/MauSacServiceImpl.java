package com.poly.assignment.ph23794.service.impl;

import com.poly.assignment.ph23794.dto.request.MauSacRequest;
import com.poly.assignment.ph23794.entity.MauSac;
import com.poly.assignment.ph23794.repository.MauSacRepository;
import com.poly.assignment.ph23794.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    private MauSacRepository MauSacRepository;

    @Autowired
    private MauSacRepository MauSacService;

    @Override
    public Page<MauSac> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return MauSacRepository.findAll(pageable);
    }

    @Override
    public void add(MauSacRequest request) {
        MauSac sp = MauSac.builder()
                .ma(request.getMa())
                .ten(request.getTen())
                .build();
        MauSacRepository.save(sp);

    }

    @Override
    public void update(MauSacRequest request) {
        MauSac sp = MauSacService.getOne(request.getId());
        sp.setMa(request.getMa());
        sp.setTen(request.getTen());

        MauSacRepository.save(sp);


    }

    @Override
    public void remove(String id) {
        MauSacRepository.deleteById(id);

    }

    @Override
    public MauSac getOne(String id) {
        return MauSacRepository.findById(id).get();
    }

    @Override
    public List<MauSac> getAll1() {
        return MauSacRepository.findAll();
    }

}
