package com.api.blogAppApi.dtos.impls;

import com.api.blogAppApi.dtos.DTO;

public record PostDTO(String autor, String titulo, String texto) implements DTO {}