package com.example.restapi.repository;

import com.example.restapi.model.BorderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorderInfoRepository extends JpaRepository<BorderInfo, String> {

}
