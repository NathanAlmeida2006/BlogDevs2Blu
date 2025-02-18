package com.api.blogAppApi.converters;

import com.api.blogAppApi.dtos.BlogAppRecordDTO;
import com.api.blogAppApi.models.BlogAppPostModel;

public interface BlogAppPostConverter {
    BlogAppPostModel toModel(BlogAppRecordDTO dto);
    BlogAppRecordDTO toDTO(BlogAppPostModel model);
}