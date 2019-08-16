package com.qfedu.service;

import com.qfedu.dao.CourseDao;
import com.qfedu.entity.Course;
import com.qfedu.models.CourseModel;
import com.qfedu.models.CourseVideoModel;

import java.util.List;
import java.util.Map;

public interface CourseService {

    public List<Course> findAllCourse();

    public Map<String,Object> findCourse(Integer page, Integer limit);

    public int addCourse(Course course);

    public int deleteById(Integer id);

    public int updateCourse(Course course);

    public Course findById(Integer id);

    public CourseVideoModel findCourseAnd(Integer id);


}
