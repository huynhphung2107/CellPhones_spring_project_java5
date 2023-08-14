package com.poly.assignment.ph23794.service;


import com.poly.assignment.ph23794.entity.GioHangChiTiet;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    List<GioHangChiTiet> getAllGioHangById(UUID idGioHangChiTiet);

    void addToCart(UUID idGioHang, UUID chiTietSP, Integer soLuong, Double donGia);
}
