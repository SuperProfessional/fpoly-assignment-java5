package com.example.assignment.services.Impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.assignment.api.admin.kichthuoc.dto.KichThuocDto;
import com.example.assignment.api.admin.mausac.dto.MauSacDto;
import com.example.assignment.framework.db.MauSacEntity;
import com.example.assignment.framework.repositories.MauSacRepository;
import com.example.assignment.services.MauSacService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MauSacServiceImpl implements MauSacService {

    private final MauSacRepository mauSacRepository;

    @Override
    public List<MauSacDto> getAll() {
        return this.mauSacRepository.findAll().stream()
                .map(
                        entity -> MauSacDto.builder()
                                .id(entity.getId())
                                .ma(entity.getMa())
                                .ten(entity.getTen())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Page<MauSacDto> getAll(Pageable pageable) {
        return this.mauSacRepository.findAll(pageable).map(
                entity -> MauSacDto.builder()
                        .id(entity.getId())
                        .ma(entity.getMa())
                        .ten(entity.getTen())
                        .trangThai(entity.getTrangThai())
                        .build()
        );
    }

    @Override
    public MauSacDto getById(Integer id) throws ServiceException {
        return this.mauSacRepository.findById(id)
                .map(
                        entity -> MauSacDto.builder()
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
    public void create(MauSacDto dto) {
        this.mauSacRepository.save(
                MauSacEntity.builder()
                        .id(dto.getId())
                        .ma(dto.getMa())
                        .ten(dto.getTen())
                        .trangThai(dto.getTrangThai())
                        .build()
        );
    }

    @Override
    public void update(MauSacDto dto, Integer id) throws ServiceException {
        this.mauSacRepository.findById(id)
                .ifPresentOrElse(
                        entity -> {
                            entity.setId(id);
                            entity.setMa(dto.getMa());
                            entity.setTen(dto.getTen());
                            entity.setTrangThai(dto.getTrangThai());

                            this.mauSacRepository.save(entity);
                        },
                        () -> new ServiceException(NOT_FOUND)
                );

    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        if (this.mauSacRepository.existsById(id)) {
            this.mauSacRepository.deleteById(id);
        } else {
            throw new ServiceException(NOT_FOUND);
        }
    }

    @Override
    public Optional<MauSacDto> findById(Integer id) {
        return this.mauSacRepository.findById(id)
                .map(
                        entity -> MauSacDto.builder()
                                .id(entity.getId())
                                .ma(entity.getMa())
                                .ten(entity.getTen())
                                .trangThai(entity.getTrangThai())
                                .build()
                );
    }
}
