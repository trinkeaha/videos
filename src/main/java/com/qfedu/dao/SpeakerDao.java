package com.qfedu.dao;

import com.qfedu.entity.Speaker;

import java.util.List;

public interface SpeakerDao {

    public List<Speaker> findAllSpeaker();

    public int addSpeaker(Speaker speaker);

    public int deleteSpeaker(Integer id);

    public int updateSpeaker(Speaker speaker);

    public Speaker findById(Integer id);
}
