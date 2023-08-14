package com.poly.assignment.ph23794.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "GioHangChiTiet")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GioHangChiTiet {

    @EmbeddedId
    private GioHangAndCTSP idGioHangChiTiet;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("IdGioHang")
    @JoinColumn(name = "IdGioHang", referencedColumnName = "id")
    private GioHang idGioHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("IdChiTietSP")
    @JoinColumn(name = "IdChiTietSP",referencedColumnName = "id")
    private ChiTietSanPham idSPCT;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;

    public double thanhTien() {
        return this.donGia * this.soLuong;
    }
    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;




}
