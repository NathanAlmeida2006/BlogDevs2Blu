package com.api.blogAppApi.services;

import com.api.blogAppApi.models.BlogAppPostModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlogAppPostService {
    BlogAppPostModel addBlogAppPost(BlogAppPostModel post);

    List<BlogAppPostModel> getAllBlogAppPosts();

    Optional<BlogAppPostModel> getBlogAppPostById(UUID id);

    BlogAppPostModel updateBlogAppPost(UUID id, BlogAppPostModel post);

    void deleteBlogAppPost(UUID id);
}