package com.example.assignment.api.admin.sanphamchitiet.dto;

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
public class SanPhamChiTietDto {

    private Integer id;

    private Integer idMauSac;

    private Integer idKichThuoc;

    private Integer idSanPham;

    private String maSPCT;

    private Integer soLuong;

    private Float donGia;

    private Integer trangThai;
}
