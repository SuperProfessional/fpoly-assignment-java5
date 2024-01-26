package com.example.assignment.services.Impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.assignment.api.admin.kichthuoc.dto.KichThuocDto;
import com.example.assignment.framework.db.KichThuocEntity;
import com.example.assignment.framework.repositories.KichThuocRepository;
import com.example.assignment.services.KichThuocService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KichThuocServiceImpl implements KichThuocService {

    private final KichThuocRepository kichThuocRepository;

    @Override
    public List<KichThuocDto> getAll() {
        return this.kichThuocRepository.findAll().stream()
                .map(
                        entity -> KichThuocDto.builder()
                                .id(entity.getId())
                                .ma(entity.getMa())
                                .ten(entity.getTen())
                                .trangThai(entity.getTrangThai())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Page<KichThuocDto> getAll(Pageable pageable) {
        return this.kichThuocRepository.findAll(pageable).map(
                entity -> KichThuocDto.builder()
                        .id(entity.getId())
                        .ma(entity.getMa())
                        .ten(entity.getTen())
                        .trangThai(entity.getTrangThai())
                        .build()
        );
    }

    @Override
    public KichThuocDto getById(Integer id) throws ServiceException {
        return this.kichThuocRepository.findById(id)
                .map(
                        entity -> KichThuocDto.builder()
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
    public void create(KichThuocDto dto) {
        this.kichThuocRepository.save(
                KichThuocEntity.builder()
                        .id(dto.getId())
                        .ma(dto.getMa())
                        .ten(dto.getTen())
                        .trangThai(dto.getTrangThai())
                        .build()
        );
    }

    @Override
    public void update(KichThuocDto dto, Integer id) throws ServiceException {
        this.kichThuocRepository.findById(id)
                .ifPresentOrElse(
                        entity -> {
                            entity.setId(id);
                            entity.setMa(dto.getMa());
                            entity.setTen(dto.getTen());
                            entity.setTrangThai(dto.getTrangThai());

                            this.kichThuocRepository.save(entity);
                        },
                        () -> new ServiceException(NOT_FOUND)
                );

    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        if (this.kichThuocRepository.existsById(id)) {
            this.kichThuocRepository.deleteById(id);
        } else {
            throw new ServiceException(NOT_FOUND);
        }
    }

    @Override
    public Optional<KichThuocDto> findById(Integer id) {
        return this.kichThuocRepository.findById(id)
                .map(
                        entity -> KichThuocDto.builder()
                                .id(entity.getId())
                                .ma(entity.getMa())
                                .ten(entity.getTen())
                                .trangThai(entity.getTrangThai())
                                .build()
                );
    }
}
