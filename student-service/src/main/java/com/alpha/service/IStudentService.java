package com.alpha.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.alpha.model.Student;

public interface IStudentService {

	 List<Student> readStudentsFromCSV(MultipartFile File) throws IOException;

	void cacheStudentsDetails(boolean checkFlag) throws Exception;
}
