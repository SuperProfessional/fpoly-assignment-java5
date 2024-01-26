package com.example.assignment.framework.repositories;

import com.example.assignment.framework.db.SanPhamChiTietEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTietEntity, Integer> {

    void deleteAllByIdSanPham(Integer id);

    @Query("SELECT e FROM SanPhamChiTietEntity e WHERE e.idSanPham = :id")
    Page<SanPhamChiTietEntity> findAllByIdSanPham(Integer id, Pageable pageable);
}
