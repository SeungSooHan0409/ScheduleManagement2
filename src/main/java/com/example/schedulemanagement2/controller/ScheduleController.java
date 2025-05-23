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


    // 일정 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getSchedule (@PathVariable Long id) {

        return new ResponseEntity<> (scheduleService.getSchedule(id), HttpStatus.OK);

    }

    // 일정 전체 수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> changeAll (
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto
    ) {

        return new ResponseEntity<>(scheduleService.put(
                id, requestDto.getUsername(),
                requestDto.getTitle(),
                requestDto.getContents()
        ), HttpStatus.OK);

    }


    // 일정의 제목만 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> changeTitle (
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto
    ) {

        return new ResponseEntity<>(scheduleService.patch(id, requestDto.getTitle()),HttpStatus.OK);

    }


    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule (@PathVariable Long id) {

        scheduleService.delete(id);

        return new ResponseEntity<> (HttpStatus.OK);

    }
}
