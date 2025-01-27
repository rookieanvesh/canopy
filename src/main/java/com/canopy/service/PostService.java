package com.canopy.service;

import com.canopy.entity.Post;

import java.util.UUID;

public interface PostService {
    Post createPost(Post post, UUID parentId);
    Post getPost(UUID id);
}