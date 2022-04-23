package com.uuu.demo1.controllers;

import com.uuu.demo1.beans.CourseForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
@Slf4j
public class CourseController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/course")
    public String showForm(CourseForm personForm) {
        return "courseForm";
    }

    @PostMapping("/course")
    public String checkCourseInfo(@Valid CourseForm form,
                                  BindingResult bindingResult) {
        log.info("course form={}", form);
        if (bindingResult.hasErrors()) {
            log.warn("Error count:{}", bindingResult.getErrorCount());
            return "courseForm";
        }
        return "redirect:/results";
    }
}
