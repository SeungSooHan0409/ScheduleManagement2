package com.example.schedulemanagement2.controller;

import com.example.schedulemanagement2.dto.ScheduleRequestDto;
import com.example.schedulemanagement2.dto.ScheduleResponseDto;
import com.example.schedulemanagement2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 작성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> postSchedule(@RequestBody ScheduleRequestDto requestDto) {

        return new ResponseEntity<> (scheduleService.post(
                requestDto.getUsername(),
                requestDto.getTitle(),
                requestDto.getContents()
        ), HttpStatus.CREATED);

    }


    // 일정 목록 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getScheduleList () {

        return new ResponseEntity<>(scheduleService.getList(),HttpStatus.OK);

    }

}
