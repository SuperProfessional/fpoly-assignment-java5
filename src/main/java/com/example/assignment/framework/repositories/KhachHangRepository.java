package com.example.assignment.framework.repositories;

import com.example.assignment.framework.db.KhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHangEntity, Integer> {
}
