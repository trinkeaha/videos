package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SpeakerDao;
import com.qfedu.entity.Speaker;
import com.qfedu.models.VideoModel;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerDao speakerDao;

    @Override
    public Map<String, Object> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Speaker> list = speakerDao.findAllSpeaker();

        // 获取总记录数
        long total = ((Page) list).getTotal();
        // 获取总页数
        int pages = ((Page) list).getPages();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @Override
    public List<Speaker> findAllSpeaker() {
        return speakerDao.findAllSpeaker();
    }

    @Override
    public int addSpeaker(Speaker speaker) {
        return speakerDao.addSpeaker(speaker);
    }

    @Override
    public int deleteSpeaker(Integer id) {
        return speakerDao.deleteSpeaker(id);
    }

    @Override
    public int updateSpeaker(Speaker speaker) {
        return speakerDao.updateSpeaker(speaker);
    }

    @Override
    public Speaker findById(Integer id) {
        return speakerDao.findById(id);
    }
}
