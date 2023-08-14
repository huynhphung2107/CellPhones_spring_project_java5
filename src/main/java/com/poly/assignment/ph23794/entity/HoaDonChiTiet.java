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
@Table(name = "HoaDonChiTiet")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class HoaDonChiTiet {

    @EmbeddedId
    private HoaDonAndCTSP id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("IdHoaDon")
    @JoinColumn(name = "IdHoaDon",referencedColumnName = "id")
    private HoaDon idHoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("IdChiTietSP")
    @JoinColumn(name = "IdChiTietSP",referencedColumnName = "id")
    private ChiTietSanPham idCTSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;


}
