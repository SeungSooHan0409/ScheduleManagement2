package com.example.schedulemanagement2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table
public class Schedule extends BaseEntity{

    @Id
    private String username;
    private String title;
    private String contents;


    public Schedule() {
    }

    public Schedule(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;


    }
}
