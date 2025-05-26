package com.example.schedulemanagement2.dto;

import com.example.schedulemanagement2.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final String title;
    private final String contents;

    public ScheduleResponseDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getTitle(),
                schedule.getContents()
        );
    }
}
