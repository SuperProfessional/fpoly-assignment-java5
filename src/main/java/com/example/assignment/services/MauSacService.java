package com.example.assignment.services;

import java.util.Optional;

import com.example.assignment.api.admin.mausac.dto.MauSacDto;

public interface MauSacService extends BaseService<MauSacDto, Integer>{
    Optional<MauSacDto> findById(Integer id);
}
