package com.qfedu.service;

import com.qfedu.entity.Speaker;

import java.util.List;
import java.util.Map;

public interface SpeakerService {

    public Map<String,Object> findByPage(Integer page, Integer limit);

    public List<Speaker> findAllSpeaker();

    public int addSpeaker(Speaker speaker);

    public int deleteSpeaker(Integer id);

    public int updateSpeaker(Speaker speaker);

    public Speaker findById(Integer id);
}
