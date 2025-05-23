package com.example.schedulemanagement2.service;

import com.example.schedulemanagement2.dto.ScheduleResponseDto;
import com.example.schedulemanagement2.entity.Schedule;
import com.example.schedulemanagement2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // post 메서드
    public ScheduleResponseDto post(String username, String title, String contents) {

        Schedule schedule = new Schedule(username, title, contents);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(username, title, contents);
    }

    // get 메서드
    public List<ScheduleResponseDto> getList() {

        return scheduleRepository.findAll().stream()
                .map(ScheduleResponseDto::toDto)
                .toList();

    }

}
