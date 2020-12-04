package com.douma.service;

import com.douma.entity.Admin;
import com.douma.entity.Student;
import com.douma.entity.Teacher;

public interface LoginService {
    Admin adminLogin(Integer username, String password);
    Teacher teacherLogin(Integer username, String password);
    Student studentLogin(Integer username, String password);
}
