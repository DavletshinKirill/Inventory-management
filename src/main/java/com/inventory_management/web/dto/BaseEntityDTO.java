package com.inventory_management.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inventory_management.web.validators.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
class BaseEntityDTO {
    @Schema(name = "id")
    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    protected UUID id;
}
