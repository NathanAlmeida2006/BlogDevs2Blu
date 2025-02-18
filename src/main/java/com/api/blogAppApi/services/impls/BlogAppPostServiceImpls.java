package com.api.blogAppApi.services.impls;

import com.api.blogAppApi.converters.BlogAppPostConverter;
import com.api.blogAppApi.models.BlogAppPostModel;
import com.api.blogAppApi.repositories.BlogAppPostRepository;
import com.api.blogAppApi.services.BlogAppPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogAppPostServiceImpls implements BlogAppPostService {

    private final BlogAppPostRepository blogAppPostRepository;

    @Autowired
    public BlogAppPostServiceImpls(BlogAppPostRepository blogAppPostRepository, BlogAppPostConverter converter) {
        this.blogAppPostRepository = blogAppPostRepository;
    }

    @Override
    public BlogAppPostModel addBlogAppPost(BlogAppPostModel post) {
        return blogAppPostRepository.save(post);
    }

    @Override
    public List<BlogAppPostModel> getAllBlogAppPosts() {
        return blogAppPostRepository.findAll();
    }

    @Override
    public Optional<BlogAppPostModel> getBlogAppPostById(UUID id) {
        return blogAppPostRepository.findById(id);
    }

    @Override
    public BlogAppPostModel updateBlogAppPost(UUID id, BlogAppPostModel post) {
        Optional<BlogAppPostModel> existingPost = blogAppPostRepository.findById(id);
        if (existingPost.isPresent()) {
            BlogAppPostModel updatedPost = existingPost.get();
            updatedPost.setTitulo(post.getTitulo());
            updatedPost.setAutor(post.getAutor());
            updatedPost.setTexto(post.getTexto());
            return blogAppPostRepository.save(updatedPost);
        }
        return null;
    }

    @Override
    public void deleteBlogAppPost(UUID id) {
        blogAppPostRepository.deleteById(id);
    }
}