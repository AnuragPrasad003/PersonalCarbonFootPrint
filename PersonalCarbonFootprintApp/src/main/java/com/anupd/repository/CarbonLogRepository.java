package com.anupd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anupd.entity.CarbonLog;
import com.anupd.entity.User;

@Repository
public interface CarbonLogRepository extends JpaRepository<CarbonLog, Integer>{
	
	List<CarbonLog> findByUser(User user);


}
