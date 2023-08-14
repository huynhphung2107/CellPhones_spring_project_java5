package com.poly.assignment.ph23794.service.impl;

import com.poly.assignment.ph23794.dto.request.NoiSanXuatRequest;
import com.poly.assignment.ph23794.entity.NoiSanXuat;
import com.poly.assignment.ph23794.repository.NoiSanXuatRepository;
import com.poly.assignment.ph23794.service.NoiSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoiSanXuatServiceImpl implements NoiSanXuatService {

    @Autowired
    private NoiSanXuatRepository NoiSanXuatRepository;

    @Autowired
    private NoiSanXuatRepository NoiSanXuatService;

    @Override
    public Page<NoiSanXuat> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return NoiSanXuatRepository.findAll(pageable);
    }

    @Override
    public void add(NoiSanXuatRequest request) {
        NoiSanXuat sp = NoiSanXuat.builder()
                .ma(request.getMa())
                .ten(request.getTen())
                .build();
        NoiSanXuatRepository.save(sp);

    }

    @Override
    public void update(NoiSanXuatRequest request) {
        NoiSanXuat sp = NoiSanXuatService.getOne(request.getId());
        sp.setMa(request.getMa());
        sp.setTen(request.getTen());

        NoiSanXuatRepository.save(sp);


    }

    @Override
    public void remove(String id) {
        NoiSanXuatRepository.deleteById(id);

    }

    @Override
    public NoiSanXuat getOne(String id) {
        return NoiSanXuatRepository.findById(id).get();
    }

    @Override
    public List<NoiSanXuat> getAll1() {
        return NoiSanXuatRepository.findAll();
    }

}
