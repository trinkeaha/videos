package com.qfedu.service;

import com.qfedu.entity.Subject;
import com.qfedu.models.SubjectModel;

import java.util.List;

public interface SubjectService {
    public List<Subject> findAllSubject();


    public SubjectModel findSubjectAnd(Integer subjectId);
}
