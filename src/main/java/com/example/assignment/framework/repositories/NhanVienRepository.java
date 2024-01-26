package com.example.assignment.framework.repositories;

import com.example.assignment.framework.db.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVienEntity, Integer> {
}
