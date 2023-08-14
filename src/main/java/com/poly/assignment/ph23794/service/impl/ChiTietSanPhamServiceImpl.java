package com.poly.assignment.ph23794.service.impl;

import com.poly.assignment.ph23794.dto.request.ChiTietSanPhamRequest;
import com.poly.assignment.ph23794.dto.response.ChiTietSanPhamResponse;
import com.poly.assignment.ph23794.entity.ChiTietSanPham;
import com.poly.assignment.ph23794.entity.DongSp;
import com.poly.assignment.ph23794.entity.MauSac;
import com.poly.assignment.ph23794.entity.NoiSanXuat;
import com.poly.assignment.ph23794.entity.SanPham;
import com.poly.assignment.ph23794.repository.ChiTietSanPhamRepository;
import com.poly.assignment.ph23794.service.ChiTietSanPhamService;
import com.poly.assignment.ph23794.service.DongSpService;
import com.poly.assignment.ph23794.service.MauSacService;
import com.poly.assignment.ph23794.service.NoiSanXuatService;
import com.poly.assignment.ph23794.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository ChiTietSanPhamRepository;

    @Autowired
    private ChiTietSanPhamRepository ChiTietSanPhamService;


    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private DongSpService dongSpService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private NoiSanXuatService noiSanXuatService;

    @Override
    public Page<ChiTietSanPhamResponse> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return ChiTietSanPhamRepository.phanTrang(pageable);
    }

    @Override
    public void add(ChiTietSanPhamRequest request) {


        ChiTietSanPham ctsp = ChiTietSanPham.builder()
                .mauSac(mauSacService.getOne(request.getTenMauSac()))
                .dongSp(dongSpService.getOne(request.getTenDsp()))
                .sanPham(sanPhamService.getOne(request.getTenSp()))
                .noiSanXuat(noiSanXuatService.getOne(request.getTenNsx()))
                .namBh(request.getNamBh())
                .soLuongTon(request.getSoLuongTon())
                .moTa(request.getMoTa())
                .giaNhap(request.getGiaNhap())
                .giaBan(request.getGiaBan())
                .build();
        ChiTietSanPhamRepository.save(ctsp);

    }

    @Override
    public void update(ChiTietSanPhamRequest request) {
        ChiTietSanPham ctsp = ChiTietSanPhamService.getOne(request.getId());
        SanPham sp = sanPhamService.getOne(request.getTenSp());

        ctsp.setNamBh(request.getNamBh());
        ctsp.setMoTa(request.getMoTa());
        ctsp.setSoLuongTon(request.getSoLuongTon());
        ctsp.setGiaNhap(request.getGiaNhap());
        ctsp.setGiaBan(request.getGiaBan());
        ChiTietSanPhamRepository.save(ctsp);


    }

    @Override
    public void remove(String id) {
        ChiTietSanPhamRepository.deleteById(id);

    }

    @Override
    public ChiTietSanPham getOne(String id) {
        return ChiTietSanPhamRepository.findById(id).get();
    }

    @Override
    public List<ChiTietSanPham> getAll1() {
        return ChiTietSanPhamRepository.findAll();
    }

}
