package com.example.assignment.services;

import java.util.Optional;

import com.example.assignment.api.admin.kichthuoc.dto.KichThuocDto;

public interface KichThuocService extends BaseService<KichThuocDto, Integer>{
    Optional<KichThuocDto> findById(Integer id);
}
