package com.poly.assignment.ph23794.repository;

import com.poly.assignment.ph23794.dto.response.NhanVienResponse;
import com.poly.assignment.ph23794.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

    @Query(value = """
            SELECT
             nv.Id AS idNv,
             nv.Ma AS maNv,
             ch.Ten AS tenCh,
             cv.Ten AS tenCv,
             CONCAT(nv.Ho,' ',nv.TenDem,' ',nv.Ten) AS hoVaTen,
             nv.GioiTinh AS gioiTinh,
             nv.NgaySinh AS ngaySinh,
             nv.DiaChi AS diaChi,
             nv.TrangThai AS trangThai
             FROM NhanVien nv JOIN CuaHang ch 
            ON nv.IdCH =ch.Id JOIN ChucVu cv
            ON nv.IdCV = cv.Id
""",nativeQuery = true)
    Page<NhanVienResponse> phanTrang(Pageable pageable);
}
