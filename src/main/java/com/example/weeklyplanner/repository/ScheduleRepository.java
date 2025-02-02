package com.example.weeklyplanner.repository;

import com.example.weeklyplanner.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByDateOrderByTimeAsc(String date);
}
