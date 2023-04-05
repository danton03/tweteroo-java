package com.tweteroo.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.User;
import com.tweteroo.api.dto.userDTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping
public class Controller {
  @PostMapping("/sign-up")
  //@ResponseStatus(code = HttpStatus.OK, reason = "OK")
  public String signup(@RequestBody @Valid userDTO req) {
    User.username = req.username();
    User.avatar = req.avatar();
    return "OK";
  }
}