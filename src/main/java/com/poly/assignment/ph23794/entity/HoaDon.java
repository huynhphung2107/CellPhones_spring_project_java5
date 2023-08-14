package com.poly.assignment.ph23794.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "HoaDon")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class HoaDon {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Long ngayTao;

    @Column(name = "NgayThanhToan")
    private Long ngayThanhToan;

    @Column(name = "NgayShip")
    private Long ngayShip;

    @Column(name = "NgayNhan")
    private Long ngayNhan;

    @Column(name = "TinhTrang")
    private int tinhTrang;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKH",referencedColumnName = "Id")
    private KhachHang idKh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNV",referencedColumnName = "Id")
    private NhanVien idNv;


}
