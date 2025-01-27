package com.canopy.controller;

import com.canopy.entity.Post;
import com.canopy.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService; // Now using interface

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Keep existing endpoints unchanged
    @PostMapping
    public Post createPost(@RequestBody Post post, @RequestParam(required = false) UUID parentId) {
        return postService.createPost(post, parentId);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable UUID id) {
        return postService.getPost(id);
    }
}