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
@Table(name = "HoaDon")
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IdKH")
    private Integer idKH;

    @Column(name = "IdNV")
    private Integer idNV;

    @Column(name = "NgayMuaHang")
    private LocalDateTime ngayMuaHang;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
