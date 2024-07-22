package com.pablogiress.api_tekos.domain.projects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataNewProject(
@NotBlank
String name,

String description,

@NotNull
LocalDateTime startDate,

LocalDateTime endDate
) {
}
