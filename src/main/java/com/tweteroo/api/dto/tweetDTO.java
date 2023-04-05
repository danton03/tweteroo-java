package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;

public record tweetDTO(
  @NotBlank
  String username,

  @NotBlank
  String tweet
) {}
