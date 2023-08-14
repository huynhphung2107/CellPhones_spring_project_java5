package com.poly.assignment.ph23794.service.impl;

import com.poly.assignment.ph23794.dto.request.KhachHangRequest;
import com.poly.assignment.ph23794.entity.KhachHang;
import com.poly.assignment.ph23794.repository.KhachHangRepository;
import com.poly.assignment.ph23794.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository KhachHangRepository;

    @Autowired
    private KhachHangRepository KhachHangService;

    @Override
    public Page<KhachHang> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return KhachHangRepository.findAll(pageable);
    }

    @Override
    public void add(KhachHangRequest request) {
        KhachHang sp = KhachHang.builder()
                .ma(request.getMa())
                .ten(request.getTen())
                .build();
        KhachHangRepository.save(sp);

    }

    @Override
    public void update(KhachHangRequest request) {
        KhachHang sp = KhachHangService.getOne(request.getId());
        sp.setMa(request.getMa());
        sp.setHo(request.getHo());
        sp.setTenDem(request.getTenDem());
        sp.setTen(request.getTen());
        sp.setNgaySinh(request.getNgaySinh());
        sp.setDiaChi(request.getDiaChi());
        sp.setThanhPho(request.getThanhPho());

        KhachHangRepository.save(sp);


    }

    @Override
    public void remove(String id) {
        KhachHangRepository.deleteById(id);

    }

    @Override
    public KhachHang getOne(String id) {
        return KhachHangRepository.findById(id).get();
    }

    @Override
    public List<KhachHang> getAll1() {
        return KhachHangRepository.findAll();
    }

}
