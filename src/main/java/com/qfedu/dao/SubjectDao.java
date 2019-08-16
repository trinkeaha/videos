package com.qfedu.dao;

import com.qfedu.entity.Subject;
import com.qfedu.models.SubjectModel;

import java.util.List;

public interface SubjectDao {
    public List<Subject> findAllSubject();

    public SubjectModel findSubjectAnd(Integer subjectId);

}
