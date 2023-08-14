package com.poly.assignment.ph23794.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ChiTietSanPhamRequest {

    private String id;

    private String tenSp;

    private String tenNsx;

    private String tenDsp;

    private String tenMauSac;

    @NotNull(message = "Không để trông thông tin")
    private Integer namBh;

    @NotNull(message = "Không để trông thông tin")
    private Integer soLuongTon;

    @NotEmpty(message = "Không để trông thông tin")
    private String moTa;

    @NotNull(message = "Không để trông thông tin")
    private Integer giaNhap;

    @NotNull(message = "Không để trông thông tin")
    private Integer giaBan;


}
