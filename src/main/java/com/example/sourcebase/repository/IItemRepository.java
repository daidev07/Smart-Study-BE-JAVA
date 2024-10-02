package com.example.sourcebase.repository;

import com.example.sourcebase.domain.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Criteria, Long> {
}
