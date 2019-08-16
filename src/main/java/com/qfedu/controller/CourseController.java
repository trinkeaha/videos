package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.Subject;
import com.qfedu.models.SubjectModel;
import com.qfedu.service.CourseService;
import com.qfedu.service.SubjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;



    @RequestMapping("/subjectList.do")
    public Map<String,Object> findAllSubject(){
        Map<String,Object> map = new HashMap<>();
        List<Subject> subject = subjectService.findAllSubject();
        map.put("subject",subject);
        return map;
    }

    @RequestMapping("/courseList.do")
    public Map<String,Object> findAllCourse(Integer page, Integer limit){
        Map<String, Object> map = courseService.findCourse(page, limit);
        return map;
    }

    @RequestMapping("/addCourse.do")
    public JsonResult addCourse(Course course){
        try{
            courseService.addCourse(course);
            return new JsonResult(1,null);
        } catch (Exception e){
            return new JsonResult(0,e.getMessage());
        }
    }

    @RequestMapping("/deleteCourse.do")
    public JsonResult deleteById(Integer id){
        try {
            courseService.deleteById(id);
            return new JsonResult(1,null);
        } catch (Exception e){
            return  new JsonResult(0,e.getMessage()) ;
        }
    }

    @RequestMapping("/updateCourse.do")
    public JsonResult updateCourse(Course course){
        try{
            courseService.updateCourse(course);
            return new JsonResult(1,null);
        } catch (Exception e){
            return new JsonResult(0,e.getMessage());
        }
    }

    @RequestMapping("/queryCourse.do")
    public JsonResult findById(Integer id){
        Course course = courseService.findById(id);
        return new JsonResult(1,course);
    }


}
