package com.seamless.CrudMysqlDocker.repo;

import com.seamless.CrudMysqlDocker.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
