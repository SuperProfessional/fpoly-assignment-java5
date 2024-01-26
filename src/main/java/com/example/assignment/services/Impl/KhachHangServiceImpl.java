package com.example.assignment.services.Impl;


import java.util.List;
import java.util.stream.Collectors;

import com.example.assignment.api.admin.khachhang.dto.KhachHangDto;
import com.example.assignment.framework.db.KhachHangEntity;
import com.example.assignment.framework.repositories.KhachHangRepository;
import com.example.assignment.services.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHangDto> getAll() {
        return this.khachHangRepository.findAll().stream()
                .map(
                        entity -> KhachHangDto.builder()
                                .id(entity.getId())
                                .ma(entity.getMa())
                                .ten(entity.getTen())
                                .sdt(entity.getSdt())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Page<KhachHangDto> getAll(Pageable pageable) {
        return this.khachHangRepository.findAll(pageable).map(
                entity -> KhachHangDto.builder()
                        .id(entity.getId())
                        .ma(entity.getMa())
                        .ten(entity.getTen())
                        .sdt(entity.getSdt())
                        .trangThai(entity.getTrangThai())
                        .build()
        );
    }

    @Override
    public KhachHangDto getById(Integer id) throws ServiceException {
        return this.khachHangRepository.findById(id)
                .map(
                        entity -> KhachHangDto.builder()
                                .id(entity.getId())
                                .ma(entity.getMa())
                                .ten(entity.getTen())
                                .sdt(entity.getSdt())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .orElseThrow(
                        () -> new ServiceException(NOT_FOUND)
                );
    }

    @Override
    public void create(KhachHangDto dto) {
        this.khachHangRepository.save(
                KhachHangEntity.builder()
                        .id(dto.getId())
                        .ma(dto.getMa())
                        .ten(dto.getTen())
                        .sdt(dto.getSdt())
                        .trangThai(dto.getTrangThai())
                        .build()
        );
    }

    @Override
    public void update(KhachHangDto dto, Integer id) throws ServiceException {
        this.khachHangRepository.findById(id)
                .ifPresentOrElse(
                        entity -> {
                            entity.setId(id);
                            entity.setMa(dto.getMa());
                            entity.setTen(dto.getTen());
                            entity.setSdt(dto.getSdt());
                            entity.setTrangThai(dto.getTrangThai());

                            this.khachHangRepository.save(entity);
                        },
                        () -> new ServiceException(NOT_FOUND)
                );

    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        if (this.khachHangRepository.existsById(id)) {
            this.khachHangRepository.deleteById(id);
        } else {
            throw new ServiceException(NOT_FOUND);
        }
    }
}
