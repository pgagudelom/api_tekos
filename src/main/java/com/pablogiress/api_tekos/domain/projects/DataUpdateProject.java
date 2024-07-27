package com.pablogiress.api_tekos.domain.projects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DataUpdateProject{

        private Long id;
        private String name;
        private String status;
        private String description;
        private LocalDateTime startDate;
        private LocalDateTime endDate;


}
