package com.example.schedulemanagement2.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String title;
    private final String contents;

    public ScheduleRequestDto(String username, String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
