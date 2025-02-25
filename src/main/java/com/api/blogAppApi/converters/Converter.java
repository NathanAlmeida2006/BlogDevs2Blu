package com.api.blogAppApi.converters;

import ch.qos.logback.core.model.Model;
import com.api.blogAppApi.dtos.DTO;

public interface Converter<D extends DTO, M extends Model> {
    M toModel(D dto);
}