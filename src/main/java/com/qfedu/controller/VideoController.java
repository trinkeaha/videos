package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.Video;
import com.qfedu.models.CourseModel;
import com.qfedu.models.VideoModel;
import com.qfedu.service.CourseService;
import com.qfedu.service.SpeakerService;
import com.qfedu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/videoList.do")
    public Map<String,Object> findByPage(HttpSession session,
                                         String searchInfo,
                                         Integer courseId,
                                         Integer speakerId,
                                         Integer page,
                                         Integer limit) {
        Map<String,Object> map = videoService.findByPage(page, limit,searchInfo,courseId,speakerId);
        return map;
    }




    @RequestMapping("/findSAC.do")
    public Map<String,Object> SpeakerAndCourse(){
        Map<String,Object> responseMap = new HashMap<>();
        List<Course> course = courseService.findAllCourse();
        List<Speaker> speaker = speakerService.findAllSpeaker();
        responseMap.put("course",course);
        responseMap.put("speaker",speaker);
        return responseMap;
    }

    @RequestMapping("/addVideo.do")
    public JsonResult addVideo(Video video){
        try{
            videoService.addVideo(video);
            return new JsonResult(1,null);
        }catch (Exception e) {
            return new JsonResult(0,e.getMessage());
        }
    }

    @RequestMapping("/queryVideo.do")
    public JsonResult findById(Integer id){
        Video video = videoService.findVideo(id);

        return new JsonResult(1,video);
    }

    @RequestMapping("/deleteVideo.do")
    public JsonResult deleteVideo(Integer id) {
        try{
            videoService.deleteVideo(id);
            return new JsonResult(1,null);
        }catch (Exception e) {
            return new JsonResult(0,e.getMessage());
        }
    }

    @RequestMapping("/updateVideo.do")
    public JsonResult updateVideo(Video video){
        try {
            videoService.updateVideo(video);
            return new JsonResult(1,null);
        }catch (Exception e) {
            return new JsonResult(0,e.getMessage());
        }
    }

    @RequestMapping("/deleteSomeVideo.do")
    public JsonResult deleteSomeVideos(String string) {
        String[] array = string.split(",");
        try {
            videoService.deleteSomeVideos(array);
            return new JsonResult(1,null);
        }catch (Exception e) {
            return new JsonResult(0,e.getMessage());
        }

    }
}
