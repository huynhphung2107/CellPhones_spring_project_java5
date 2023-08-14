package com.poly.assignment.ph23794.repository;

import com.poly.assignment.ph23794.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, String> {


}
