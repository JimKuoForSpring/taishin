package com.uuu.demo1.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseForm {
    @NotEmpty
    @Size(min = 5, max = 30)
    private String courseId;
    @NotEmpty
    private String courseName;
    @NotNull
    @Min(7)
    private Integer duration;

}
