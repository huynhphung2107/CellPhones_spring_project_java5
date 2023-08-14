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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NoiSanXuatRequest {

    private String id;

    @NotEmpty(message = "Không để trông thông tin")
    private String ma;

    @NotEmpty(message = "Không để trông thông tin")
    private String ten;


}
