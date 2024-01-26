package com.example.assignment.framework.repositories;

import com.example.assignment.framework.db.MauSacEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSacEntity, Integer> {
}
