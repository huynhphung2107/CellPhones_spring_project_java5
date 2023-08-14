package com.poly.assignment.ph23794.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class GioHangAndCTSP implements Serializable {

    @Column(name = "IdGioHang")
    private UUID gioHangId;

    @Column(name = "IdChiTietSP")
    private UUID chiTietSPId;
}
