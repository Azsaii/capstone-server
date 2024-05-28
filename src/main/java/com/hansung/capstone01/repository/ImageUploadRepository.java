package com.hansung.capstone01.repository;

import com.hansung.capstone01.domain.ImageUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageUploadRepository extends JpaRepository<ImageUpload, Long> {
}

