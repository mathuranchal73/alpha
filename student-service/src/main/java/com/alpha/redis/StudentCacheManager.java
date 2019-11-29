package com.alpha.redis;

import com.alpha.model.Student;

public interface StudentCacheManager {

	void cacheStudentDetails(Student students);

	boolean checkEmpty();

}
