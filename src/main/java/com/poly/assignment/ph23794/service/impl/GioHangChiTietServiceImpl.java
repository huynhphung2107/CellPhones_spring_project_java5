package com.poly.assignment.ph23794.service.impl;


import com.poly.assignment.ph23794.entity.GioHang;
import com.poly.assignment.ph23794.entity.GioHangChiTiet;
import com.poly.assignment.ph23794.repository.GioHangChiTietRepository;
import com.poly.assignment.ph23794.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    private Map<UUID, Integer> sanPhamTrongGio = new HashMap<>();

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<GioHangChiTiet> getAllGioHangById(UUID idGioHangChiTiet) {
        return gioHangChiTietRepository.getAllGioHangById(idGioHangChiTiet);
    }

    public void themSanPhamVaoGio(UUID idGioHang, Integer soLuongChoVao) {
        sanPhamTrongGio = (Map<UUID, Integer>) getAllGioHangById(idGioHang);
        if (sanPhamTrongGio.containsKey(idGioHang)) {
            Integer soLuongHienCo = sanPhamTrongGio.get(idGioHang);
            Integer soLuongMoi = soLuongHienCo + soLuongChoVao;
            sanPhamTrongGio.put(idGioHang, soLuongMoi);
        } else {
            sanPhamTrongGio.put(idGioHang, soLuongChoVao);
        }
    }

    @Override
    public void addToCart(UUID idGioHang, UUID chiTietSP, Integer soLuong, Double donGia) {
        GioHang gioHang = new GioHang();
        themSanPhamVaoGio(idGioHang, soLuong);
    }
}
