package com.example.weeklyplanner.repository;

import com.example.weeklyplanner.model.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
