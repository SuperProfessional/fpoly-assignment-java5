package com.example.assignment.api.admin.hoadonchitiet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MauSacChiTietDto {

    private Integer id;

    private String ma;

    private String ten;

    private Integer trangThai;
}
