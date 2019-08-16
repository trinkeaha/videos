package com.qfedu.dao;

import com.qfedu.entity.Video;
import com.qfedu.models.VideoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoDao {

    public List<VideoModel> findAllVideo(@Param("searchInfo")String searchInfo,
                                         @Param("courseId")Integer courseId,
                                         @Param("speakerId")Integer speakerId);

    public int addVideo(Video video);

    public int updateVideo(Video video);

    public Video findById(Integer id);

    public int deleteById(Integer id);

    public int deleteSomeVideos(String[] arr);

    public VideoModel videoAndSpeaker(Integer id);


}
