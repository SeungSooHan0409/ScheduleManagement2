package com.example.schedulemanagement2.repository;

import com.example.schedulemanagement2.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
}
