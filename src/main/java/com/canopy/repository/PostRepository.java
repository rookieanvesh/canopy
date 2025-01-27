package com.canopy.repository;

import com.canopy.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByParentId(UUID parentId);
}