package com.canopy.service;

import com.canopy.entity.Post;
import com.canopy.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public Post createPost(Post post, UUID parentId) {
        if (parentId != null) {
            Post parent = postRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent post not found"));
            post.setParent(parent);
        }
        return postRepository.save(post);
    }

    @Override
    public Post getPost(UUID id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Post not found"));
    }
}