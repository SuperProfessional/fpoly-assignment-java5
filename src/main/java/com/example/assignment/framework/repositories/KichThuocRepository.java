package com.example.assignment.framework.repositories;

import com.example.assignment.framework.db.KichThuocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuocEntity, Integer> {
}
