package com.inventory_management.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inventory_management.web.validators.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
class BaseEntityDTO {
    @Schema(name = "id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull(message = "Id must be not null", groups = {OnUpdate.class})
    protected Long UUID;
}
