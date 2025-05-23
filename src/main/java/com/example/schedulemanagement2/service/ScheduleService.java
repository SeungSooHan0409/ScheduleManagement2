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

    // get 메서드 - 목록조회
    public List<ScheduleResponseDto> getList() {

        return scheduleRepository.findAll().stream()
                .map(ScheduleResponseDto::toDto)
                .toList();

    }

    // get 메서드 - 단건조회
    public ScheduleResponseDto getSchedule(Long id) {

        Schedule schedule =  scheduleRepository.bringOptionalValue(id);

        return new ScheduleResponseDto(schedule.getUsername(), schedule.getTitle(), schedule.getContents());

    }

    // put 메서드
    public ScheduleResponseDto put(Long id, String username, String title, String contents) {

        Schedule schedule = scheduleRepository.bringOptionalValue(id);

        schedule.setUsername(username);
        schedule.setTitle(title);
        schedule.setContents(contents);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(username, title, contents);

    }

    // patch 메서드
    public ScheduleResponseDto patch(Long id, String title) {

        Schedule schedule = scheduleRepository.bringOptionalValue(id);

        schedule.setTitle(title);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getUsername(), schedule.getTitle(), schedule.getContents());
    }

    // delete 메서드
    public void delete(Long id) {

        scheduleRepository.deleteById(id);

    }

}
