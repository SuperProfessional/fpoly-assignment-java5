package com.example.assignment.services.Impl;


import java.util.List;
import java.util.stream.Collectors;

import com.example.assignment.api.admin.sanpham.dto.SanPhamDto;
import com.example.assignment.framework.db.SanPhamEntity;
import com.example.assignment.framework.repositories.SanPhamChiTietRepository;
import com.example.assignment.framework.repositories.SanPhamRepository;
import com.example.assignment.services.SanPhamService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SanPhamServiceImpl implements SanPhamService {

    private final SanPhamRepository sanPhamRepository;

    private final SanPhamChiTietRepository sanPhamChiTietRepository;

    @Override
    public List<SanPhamDto> getAll() {
        return this.sanPhamRepository.findAll().stream()
                .map(
                        entity -> SanPhamDto.builder()
                                .id(entity.getId())
                                .ma(entity.getMa())
                                .ten(entity.getTen())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Page<SanPhamDto> getAll(Pageable pageable) {
        return this.sanPhamRepository.findAll(pageable).map(
                entity -> SanPhamDto.builder()
                        .id(entity.getId())
                        .ma(entity.getMa())
                        .ten(entity.getTen())
                        .trangThai(entity.getTrangThai())
                        .build()
        );
    }

    @Override
    public SanPhamDto getById(Integer id) throws ServiceException {
        return this.sanPhamRepository.findById(id)
                .map(
                        entity -> SanPhamDto.builder()
                                .id(entity.getId())
                                .ma(entity.getMa())
                                .ten(entity.getTen())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .orElseThrow(
                        () -> new ServiceException(NOT_FOUND)
                );
    }

    @Override
    public void create(SanPhamDto dto) {
        this.sanPhamRepository.save(
                SanPhamEntity.builder()
                        .id(dto.getId())
                        .ma(dto.getMa())
                        .ten(dto.getTen())
                        .trangThai(dto.getTrangThai())
                        .build()
        );
    }

    @Override
    public void update(SanPhamDto dto, Integer id) throws ServiceException {
        this.sanPhamRepository.findById(id)
                .ifPresentOrElse(
                        entity -> {
                            entity.setId(id);
                            entity.setMa(dto.getMa());
                            entity.setTen(dto.getTen());
                            entity.setTrangThai(dto.getTrangThai());

                            this.sanPhamRepository.save(entity);
                        },
                        () -> new ServiceException(NOT_FOUND)
                );

    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        if (this.sanPhamRepository.existsById(id)) {
            this.sanPhamChiTietRepository.deleteAllByIdSanPham(id);
            this.sanPhamRepository.deleteById(id);
        } else {
            throw new ServiceException(NOT_FOUND);
        }
    }
}
