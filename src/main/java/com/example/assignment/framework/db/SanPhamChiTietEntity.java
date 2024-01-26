package com.example.assignment.framework.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@Table(name = "SanPhamChiTiet")
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamChiTietEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IdMauSac")
    private Integer idMauSac;

    @Column(name = "IdKichThuoc")
    private Integer idKichThuoc;

    @Column(name = "IdSanPham")
    private Integer idSanPham;

    @Column(name = "MaSPCT")
    private String maSPCT;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Float donGia;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
