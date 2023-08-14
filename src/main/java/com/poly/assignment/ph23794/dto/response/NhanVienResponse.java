package com.poly.assignment.ph23794.dto.response;

import com.poly.assignment.ph23794.entity.NhanVien;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {NhanVien.class})
public interface NhanVienResponse {

    @Value("#{target.idNv}")
    String getId();

    @Value("#{target.maNv}")
    String getMa();

    @Value("#{target.tenCh}")
    String getTenCh();

    @Value("#{target.tenCv}")
    String getTenCv();

    @Value("#{target.hoVaTen}")
    String getHoTen();

    @Value("#{target.gioiTinh}")
    String getGioiTinh();

    @Value("#{target.ngaySinh}")
    String getNgaySinh();

    @Value("#{target.diaChi}")
    String getDiaChi();

    @Value("#{target.trangThai}")
    String getTrangThai();
}
