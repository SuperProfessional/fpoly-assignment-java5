package com.example.assignment.services.Impl;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.assignment.api.admin.sanphamchitiet.dto.SanPhamChiTietDto;
import com.example.assignment.framework.db.SanPhamChiTietEntity;
import com.example.assignment.framework.repositories.SanPhamChiTietRepository;
import com.example.assignment.framework.repositories.SanPhamRepository;
import com.example.assignment.services.SanPhamChiTietService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {

    private final SanPhamChiTietRepository sanPhamChiTietRepository;

    private final SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPhamChiTietDto> getAll() {
        return this.sanPhamChiTietRepository.findAll().stream()
                .map(
                        entity -> SanPhamChiTietDto.builder()
                                .id(entity.getId())
                                .idMauSac(entity.getIdMauSac())
                                .idKichThuoc(entity.getIdKichThuoc())
                                .idSanPham(entity.getIdSanPham())
                                .maSPCT(entity.getMaSPCT())
                                .soLuong(entity.getSoLuong())
                                .donGia(entity.getDonGia())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Page<SanPhamChiTietDto> getAll(Pageable pageable) {
        return this.sanPhamChiTietRepository.findAll(pageable).map(
                entity -> SanPhamChiTietDto.builder()
                        .id(entity.getId())
                        .idMauSac(entity.getIdMauSac())
                        .idKichThuoc(entity.getIdKichThuoc())
                        .idSanPham(entity.getIdSanPham())
                        .maSPCT(entity.getMaSPCT())
                        .soLuong(entity.getSoLuong())
                        .donGia(entity.getDonGia())
                        .trangThai(entity.getTrangThai())
                        .build()
        );
    }

    @Override
    public SanPhamChiTietDto getById(Integer id) throws ServiceException {
        return this.sanPhamChiTietRepository.findById(id)
                .map(
                        entity -> SanPhamChiTietDto.builder()
                                .id(entity.getId())
                                .idMauSac(entity.getIdMauSac())
                                .idKichThuoc(entity.getIdKichThuoc())
                                .idSanPham(entity.getIdSanPham())
                                .maSPCT(entity.getMaSPCT())
                                .soLuong(entity.getSoLuong())
                                .donGia(entity.getDonGia())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .orElseThrow(
                        () -> new ServiceException(NOT_FOUND)
                );
    }

    @Override
    public void create(SanPhamChiTietDto dto) {
        this.sanPhamChiTietRepository.save(
                SanPhamChiTietEntity.builder()
                        .id(dto.getId())
                        .idMauSac(dto.getIdMauSac())
                        .idKichThuoc(dto.getIdKichThuoc())
                        .idSanPham(dto.getIdSanPham())
                        .maSPCT(dto.getMaSPCT())
                        .soLuong(dto.getSoLuong())
                        .donGia(dto.getDonGia())
                        .trangThai(dto.getTrangThai())
                        .build()
        );
    }

    @Override
    public void update(SanPhamChiTietDto dto, Integer id) throws ServiceException {
        this.sanPhamChiTietRepository.findById(id)
                .ifPresentOrElse(
                        entity -> {
                            entity.setId(id);
                            entity.setIdMauSac(dto.getIdMauSac());
                            entity.setIdKichThuoc(dto.getIdKichThuoc());
                            entity.setIdSanPham(dto.getIdSanPham());
                            entity.setMaSPCT(dto.getMaSPCT());
                            entity.setSoLuong(dto.getSoLuong());
                            entity.setDonGia(dto.getDonGia());
                            entity.setTrangThai(dto.getTrangThai());

                            this.sanPhamChiTietRepository.save(entity);
                        },
                        () -> new ServiceException(NOT_FOUND)
                );

    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        if (this.sanPhamChiTietRepository.existsById(id)) {
            this.sanPhamChiTietRepository.deleteById(id);
        } else {
            throw new ServiceException(NOT_FOUND);
        }
    }

    @Override
    public Page<SanPhamChiTietDto> getAllByIdSanPham(Integer id, Pageable pageable) {

        if (Objects.isNull(id)) {
            throw new ServiceException(NOT_FOUND);
        }
        return this.sanPhamChiTietRepository.findAllByIdSanPham(id, pageable).map(
                entity -> SanPhamChiTietDto.builder()
                        .id(entity.getId())
                        .idMauSac(entity.getIdMauSac())
                        .idKichThuoc(entity.getIdKichThuoc())
                        .idSanPham(entity.getIdSanPham())
                        .maSPCT(entity.getMaSPCT())
                        .soLuong(entity.getSoLuong())
                        .donGia(entity.getDonGia())
                        .trangThai(entity.getTrangThai())
                        .build()
        );
    }

}
