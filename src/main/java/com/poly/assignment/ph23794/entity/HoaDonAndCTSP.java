package com.poly.assignment.ph23794.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class HoaDonAndCTSP implements Serializable {
    @Column(name = "IdHoaDon")
    private UUID hoaDonId;

    @Column(name = "IdChiTietSP")
    private UUID chiTietSPId;
}
