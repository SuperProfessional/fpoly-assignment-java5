package com.example.assignment.services.Impl;


import java.util.List;
import java.util.stream.Collectors;

import com.example.assignment.api.admin.nhanvien.dto.NhanVienDto;
import com.example.assignment.framework.db.NhanVienEntity;
import com.example.assignment.framework.repositories.NhanVienRepository;
import com.example.assignment.services.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVienDto> getAll() {
        return this.nhanVienRepository.findAll().stream()
                .map(
                        entity -> NhanVienDto.builder()
                                .id(entity.getId())
                                .ten(entity.getTen())
                                .ma(entity.getMa())
                                .tenDangNhap(entity.getTenDangNhap())
                                .matKhau(entity.getMatKhau())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Page<NhanVienDto> getAll(Pageable pageable) {
        return this.nhanVienRepository.findAll(pageable).map(
                entity -> NhanVienDto.builder()
                        .id(entity.getId())
                        .ten(entity.getTen())
                        .ma(entity.getMa())
                        .tenDangNhap(entity.getTenDangNhap())
                        .matKhau(entity.getMatKhau())
                        .trangThai(entity.getTrangThai())
                        .build()
        );
    }

    @Override
    public NhanVienDto getById(Integer id) throws ServiceException {
        return this.nhanVienRepository.findById(id)
                .map(
                        entity -> NhanVienDto.builder()
                                .id(entity.getId())
                                .ten(entity.getTen())
                                .ma(entity.getMa())
                                .tenDangNhap(entity.getTenDangNhap())
                                .matKhau(entity.getMatKhau())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .orElseThrow(
                        () -> new ServiceException(NOT_FOUND)
                );
    }

    @Override
    public void create(NhanVienDto dto) {
        this.nhanVienRepository.save(
                NhanVienEntity.builder()
                        .id(dto.getId())
                        .ten(dto.getTen())
                        .ma(dto.getMa())
                        .tenDangNhap(dto.getTenDangNhap())
                        .matKhau(dto.getMatKhau())
                        .trangThai(dto.getTrangThai())
                        .build()
        );
    }

    @Override
    public void update(NhanVienDto dto, Integer id) throws ServiceException {
        this.nhanVienRepository.findById(id)
                .ifPresentOrElse(
                        entity -> {
                            entity.setId(id);
                            entity.setTen(dto.getTen());
                            entity.setMa(dto.getMa());
                            entity.setTenDangNhap(dto.getTenDangNhap());
                            entity.setMatKhau(dto.getMatKhau());
                            entity.setTrangThai(dto.getTrangThai());

                            this.nhanVienRepository.save(entity);
                        },
                        () -> new ServiceException(NOT_FOUND)
                );

    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        if (this.nhanVienRepository.existsById(id)) {
            this.nhanVienRepository.deleteById(id);
        } else {
            throw new ServiceException(NOT_FOUND);
        }
    }
}
