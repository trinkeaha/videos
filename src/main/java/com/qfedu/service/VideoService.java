package com.qfedu.service;

import com.qfedu.entity.Video;
import com.qfedu.models.VideoModel;

import java.util.List;
import java.util.Map;

public interface VideoService {

    public Map<String,Object> findByPage(Integer page,Integer limit,String searchInfo,Integer courseId,Integer speakerId);

    public Video findVideo(Integer id);

    public int addVideo(Video video);

    public int deleteVideo(Integer id);

    public int updateVideo(Video video);

    public int deleteSomeVideos(String[] arr);

    public VideoModel videoAndSpeaker(Integer id);

}
