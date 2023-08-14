package com.poly.assignment.ph23794.repository;


import com.poly.assignment.ph23794.entity.GioHang;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    @Transactional
    @Modifying
    @Query(value = "update GioHang set TinhTrang = 1 where id=:id", nativeQuery = true)
    void huyGioHang(@Param("id") UUID idGioHang);

    @Query(value = "select * from GioHang where ma=:ma", nativeQuery = true)
    List<GioHang> searchMaGH(@Param("ma") String maGioHang);
}
