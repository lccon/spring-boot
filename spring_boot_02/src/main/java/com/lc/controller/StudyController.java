package com.lc.controller;

import com.lc.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @Date:2019/4/14
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class StudyController {

    @Autowired
    Person person;

    @ResponseBody
    @RequestMapping("/study")
    public Person study() {
        System.out.println(person);
        return person;
    }
}
