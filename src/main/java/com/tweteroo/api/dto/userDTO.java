package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record userDTO(
  @NotBlank
  String username,

  @NotBlank
  /* @Pattern(regexp = "/(https?:\\.*\\.(?:png|jpg))/i") */
  String avatar
) {}
