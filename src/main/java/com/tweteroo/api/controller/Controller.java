package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.tweetDTO;
import com.tweteroo.api.dto.userDTO;
import com.tweteroo.api.services.TweetService;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping
public class Controller {
  @Autowired
  private static UserService userService;

  @Autowired
  private static TweetService tweetService;
  
  private Controller() {
    //construtor implícito
  }

  @PostMapping("/sign-up")
  public static String signup(@RequestBody @Valid userDTO req) {
    userService.save(req);
    return "OK";
  }

  @PostMapping("/tweets")
  public static String createTweet(@RequestBody @Valid tweetDTO req) {
    tweetService.save(req);
    return "OK";
  }

}