package com.application.springbootapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;

public record ClientRecordDto(@NotBlank String name, @NotNull ZonedDateTime birth_date, @NotNull String phone) {
}
