package com.example.assignment.framework.db;

import java.time.LocalDateTime;

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
@Table(name = "HoaDonChiTiet")
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTietEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IdHoaDon")
    private Integer idHoaDon;

    @Column(name = "IdSPCT")
    private Integer idSPCT;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Integer donGia;

    @Column(name = "ThoiGian")
    private LocalDateTime thoiGian;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
