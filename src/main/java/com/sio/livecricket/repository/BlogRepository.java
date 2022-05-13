package com.sio.livecricket.repository;

import com.sio.livecricket.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Blog, Long> {
}