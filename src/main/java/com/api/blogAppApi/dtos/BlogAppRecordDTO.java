package com.api.blogAppApi.dtos;

import jakarta.validation.constraints.NotBlank;

public record BlogAppRecordDTO(@NotBlank String autor, @NotBlank String titulo, @NotBlank String texto) {
}
