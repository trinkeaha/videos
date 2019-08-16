package com.qfedu.dao;

import com.qfedu.entity.Course;
import com.qfedu.models.CourseModel;
import com.qfedu.models.CourseVideoModel;

import java.util.List;

public interface CourseDao {

    public List<Course> findAllCourse();

    public List<Course> findBySubjectId(Integer id);

    public int addCourse(Course course);

    public int deleteById(Integer id);

    public int updateCourse(Course course);

    public Course findById(Integer id);

    public CourseVideoModel findCourseAnd(Integer id);

}
