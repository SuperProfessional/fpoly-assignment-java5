package com.example.assignment.services;

import com.example.assignment.api.admin.sanphamchitiet.dto.SanPhamChiTietDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SanPhamChiTietService extends BaseService<SanPhamChiTietDto, Integer>{

    Page<SanPhamChiTietDto> getAllByIdSanPham(Integer id, Pageable pageable);
}
