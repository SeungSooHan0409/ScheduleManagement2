package com.example.schedulemanagement2.dto;

import com.example.schedulemanagement2.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private String username;
    private String title;
    private String contents;

    public ScheduleResponseDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getUsername(),
                schedule.getTitle(),
                schedule.getContents()
        );
    }
}
