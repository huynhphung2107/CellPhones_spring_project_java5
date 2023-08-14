package com.poly.assignment.ph23794.repository;

import com.poly.assignment.ph23794.dto.response.ChiTietSanPhamResponse;
import com.poly.assignment.ph23794.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, String> {
    @Query(value = """
                        SELECT
                         ct.Id AS idCtsp,
                         sp.Ten AS tenSp,
                         nsx.Ten AS tenNsx,
                         ms.Ten AS tenMauSac,
                         dsp.Ten AS tenDongSp,
                         ct.NamBH AS namBh,
                         ct.MoTa AS moTa,
                         ct.SoLuongTon AS soLuongTon,
                         ct.GiaNhap AS giaNhap,
                         ct.giaBan AS giaBan
                         FROM ChiTietSP ct JOIN SanPham sp 
                        ON sp.Id = ct.IdSP JOIN NSX nsx 
                        ON nsx.Id =ct.IdNsx JOIN MauSac ms 
                        ON ms.Id = ct.IdMauSac JOIN DongSP dsp 
                        ON dsp.Id = ct.IdDongSP
            """, nativeQuery = true)
    Page<ChiTietSanPhamResponse> phanTrang(Pageable pageable);
}
