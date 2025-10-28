package com.ssg.springwebmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private Boolean finished;
    private String writer;
}
