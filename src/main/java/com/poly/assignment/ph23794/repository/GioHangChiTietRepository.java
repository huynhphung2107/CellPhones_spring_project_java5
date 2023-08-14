package com.poly.assignment.ph23794.repository;


import com.poly.assignment.ph23794.entity.GioHangChiTiet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, String> {
    @Query(value = "select * from GioHangChiTiet where IdGioHang =:id", nativeQuery = true)
    List<GioHangChiTiet> getAllGioHangById(@Param("id") UUID idGioHangChiTiet);

    @Transactional
    @Modifying
    @Query(value = "insert into GioHangChiTiet(IdGioHang, IdChiTietSP, SoLuong, DonGia) values (:idGioHang, :idChiTietSP, :soLuong, :donGia)", nativeQuery = true)
    void addToCart(@Param("idGioHang") UUID idGioHang, @Param("idChiTietSP") UUID chiTietSP, @Param("soLuong") Integer soLuong, @Param("donGia") Double donGia);
}
