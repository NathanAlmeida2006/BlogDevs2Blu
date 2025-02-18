package com.api.blogAppApi.converters.impls;

import com.api.blogAppApi.converters.BlogAppPostConverter;
import com.api.blogAppApi.dtos.BlogAppRecordDTO;
import com.api.blogAppApi.models.BlogAppPostModel;
import org.springframework.stereotype.Component;

@Component
public class BlogAppPostConverterImpl implements BlogAppPostConverter {

    @Override
    public BlogAppPostModel toModel(BlogAppRecordDTO dto) {
        BlogAppPostModel model = new BlogAppPostModel();
        model.setAutor(dto.autor());
        model.setTitulo(dto.titulo());
        model.setTexto(dto.texto());
        return model;
    }

    @Override
    public BlogAppRecordDTO toDTO(BlogAppPostModel model) {
        return new BlogAppRecordDTO(
                model.getAutor(),
                model.getTitulo(),
                model.getTexto()
        );
    }
}