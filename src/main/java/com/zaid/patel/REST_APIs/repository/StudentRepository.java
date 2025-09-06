package com.zaid.patel.REST_APIs.repository;

import com.zaid.patel.REST_APIs.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {                //via JpaRepository you get all the methods Like CURD and all

}
