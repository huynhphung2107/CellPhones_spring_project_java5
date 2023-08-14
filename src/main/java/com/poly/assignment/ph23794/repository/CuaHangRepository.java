package com.poly.assignment.ph23794.repository;

import com.poly.assignment.ph23794.entity.CuaHang;
import com.poly.assignment.ph23794.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang,String> {
}
