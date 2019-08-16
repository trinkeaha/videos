package com.qfedu.controller;

import com.qfedu.models.CourseModel;
import com.qfedu.models.CourseVideoModel;
import com.qfedu.models.SubjectModel;
import com.qfedu.models.VideoModel;
import com.qfedu.service.CourseService;
import com.qfedu.service.SubjectService;
import com.qfedu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SubjectController {


    @Autowired
    private SubjectService subjectService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/course/list.do")
    public String courseAndList(String subjectId, Model model){
        SubjectModel sub = subjectService.findSubjectAnd(Integer.parseInt(subjectId));
        model.addAttribute("subject",sub);
        return "course";
    }

    @RequestMapping("/showVideo.do")
    public ModelAndView showVideo(Integer videoId, String subjectName){
        Map<String,Object> map = new HashMap<>();
        VideoModel videoModel = videoService.videoAndSpeaker(videoId);
        CourseVideoModel course = courseService.findCourseAnd(videoModel.getCourseId());

        map.put("video",videoModel);
        map.put("subjectName",subjectName);
        map.put("course",course);

        return new ModelAndView("section",map);
    }
}
