package com.viethoang.week07.repository;

import com.viethoang.week07.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
