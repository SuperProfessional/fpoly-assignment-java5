package com.example.assignment.api.admin.sanphamchitiet.dto;

import com.example.assignment.api.admin.kichthuoc.dto.KichThuocDto;
import com.example.assignment.api.admin.mausac.dto.MauSacDto;
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
public class SanPhamChiTietViewIndex {
    private Integer id;

    private MauSacDto mauSac;

    private KichThuocDto kichThuoc;

    private String maSPCT;

    private Integer soLuong;

    private Float donGia;

    private Integer trangThai;
}
