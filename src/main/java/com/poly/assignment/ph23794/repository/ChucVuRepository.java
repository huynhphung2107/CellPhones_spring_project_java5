package com.poly.assignment.ph23794.repository;

import com.poly.assignment.ph23794.entity.ChucVu;
import com.poly.assignment.ph23794.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu,String> {
}
