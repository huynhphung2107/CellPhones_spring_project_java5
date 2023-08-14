package com.poly.assignment.ph23794.dto.response;

import com.poly.assignment.ph23794.entity.ChiTietSanPham;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {ChiTietSanPham.class})
public interface ChiTietSanPhamResponse {

    @Value("#{target.idCtsp}")
    String getId();

    @Value("#{target.tenSp}")
    String getTenSp();

    @Value("#{target.tenMauSac}")
    String getTenMauSac();

    @Value("#{target.tenDongSp}")
    String getTenDongSp();

    @Value("#{target.tenNsx}")
    String gettenNsx();

    @Value("#{target.namBh}")
    Integer getNamBh();

    @Value("#{target.moTa}")
    String getMota();

    @Value("#{target.soLuongTon}")
    Integer getSoLuongTon();

    @Value("#{target.giaNhap}")
    Integer getGiaNhap();

    @Value("#{target.giaBan}")
    Integer getGiaBan();
}
