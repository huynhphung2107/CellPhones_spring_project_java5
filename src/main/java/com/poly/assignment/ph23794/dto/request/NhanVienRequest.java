package com.poly.assignment.ph23794.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class NhanVienRequest {

    private String id;

    private String tenCh;

    private String tenCv;

    @NotEmpty(message = "Khong de trong thong tin")
    private String ma;

    @NotEmpty(message = "Khong de trong thong tin")
    private String ho;

    @NotEmpty(message = "Khong de trong thong tin")
    private String tenDem;

    @NotEmpty(message = "Khong de trong thong tin")
    private String ten;

    private String gioiTinh;

    private String ngaySinh;

    @NotEmpty(message = "Khong de trong thong tin")
    private String diaChi;

    private Integer trangThai;
}
