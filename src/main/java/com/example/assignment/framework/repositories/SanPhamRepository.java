package com.example.assignment.framework.repositories;

import com.example.assignment.framework.db.SanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Integer> {
}
