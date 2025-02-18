package com.api.blogAppApi.repositories;

import com.api.blogAppApi.models.BlogAppPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogAppPostRepository extends JpaRepository<BlogAppPostModel, UUID> {
}
