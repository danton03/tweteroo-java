package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;

public record userDTO(
  @NotBlank
  String username,

  @NotBlank
  /* @Pattern(regexp = "/(https?:\\.*\\.(?:png|jpg))/i") */
  String avatar
) {}
