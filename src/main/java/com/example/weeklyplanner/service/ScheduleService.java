package com.example.weeklyplanner.service;

import com.example.weeklyplanner.model.Schedule;
import com.example.weeklyplanner.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesByDate(String date) {
        return scheduleRepository.findByDateOrderByTimeAsc(date);
    }

    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    // 스케줄 수정 기능 추가
    public Schedule updateSchedule(Long id, Schedule schedule) {
        if (!scheduleRepository.existsById(id)) {
            throw new RuntimeException("Schedule not found with id: " + id);
        }
        schedule.setId(id); // 기존 ID로 업데이트
        return scheduleRepository.save(schedule);
    }

    // 단일 스케줄 가져오기
    public Schedule getScheduleById(Long id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        if (schedule.isPresent()) {
            return schedule.get();
        } else {
            throw new RuntimeException("Schedule not found with id: " + id);
        }
    }
}
