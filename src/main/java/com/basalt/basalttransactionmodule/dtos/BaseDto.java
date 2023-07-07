package com.basalt.basalttransactionmodule.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class BaseDto {
    protected String id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    protected OffsetDateTime dateCreated;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    protected OffsetDateTime lastUpdated;
}
