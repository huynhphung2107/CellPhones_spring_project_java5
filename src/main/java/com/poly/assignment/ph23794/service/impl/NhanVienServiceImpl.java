package com.poly.assignment.ph23794.service.impl;

import com.poly.assignment.ph23794.dto.request.NhanVienRequest;
import com.poly.assignment.ph23794.dto.response.NhanVienResponse;
import com.poly.assignment.ph23794.entity.ChucVu;
import com.poly.assignment.ph23794.entity.CuaHang;
import com.poly.assignment.ph23794.entity.NhanVien;
import com.poly.assignment.ph23794.repository.NhanVienRepository;
import com.poly.assignment.ph23794.service.ChucVuService;
import com.poly.assignment.ph23794.service.CuaHangService;
import com.poly.assignment.ph23794.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVienRepository NhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private CuaHangService cuaHangService;


    @Override
    public Page<NhanVienResponse> getAll(Integer pageNo, Integer pageSize) {
        Pageable pageable  = PageRequest.of(pageNo,pageSize);
        return nhanVienRepository.phanTrang(pageable);
    }

    @Override
    public void add(NhanVienRequest request) {

        NhanVien sp = NhanVien.builder()
                .id(request.getId())
                .ma(request.getMa())
                .chucVu(chucVuService.getOne(request.getTenCv()))
                .cuaHang(cuaHangService.getOne(request.getTenCh()))
                .ho(request.getHo())
                .tenDem(request.getTenDem())
                .ten(request.getTen())
                .gioiTinh(request.getGioiTinh())
                .ngaySinh(request.getNgaySinh())
                .diaChi(request.getDiaChi())
                .trangThai(request.getTrangThai())
                .build();
        nhanVienRepository.save(sp);

    }

    @Override
    public void update(NhanVienRequest request) {
        CuaHang ch = cuaHangService.getOne(request.getTenCh());
        ChucVu cv = chucVuService.getOne(request.getTenCv());
        NhanVien sp = NhanVienService.getOne(request.getId());
//        sp.setCuaHang(ch.getTen());
//        sp.setChucVu(cv);
        sp.setMa(request.getMa());
        sp.setHo(request.getHo());
        sp.setTenDem(request.getTenDem());
        sp.setTen(request.getTen());
        sp.setGioiTinh(request.getGioiTinh());
        sp.setNgaySinh(request.getNgaySinh());
        sp.setDiaChi(request.getDiaChi());
        sp.setTrangThai(request.getTrangThai());

        nhanVienRepository.save(sp);


    }

    @Override
    public void remove(String id) {
        nhanVienRepository.deleteById(id);

    }

    @Override
    public NhanVien getOne(String id) {
        return nhanVienRepository.findById(id).get();
    }

    @Override
    public List<NhanVien> getAll1() {
        return nhanVienRepository.findAll();
    }

}
