package com.tweteroo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.TweetInfo;
import com.tweteroo.api.TweetList;
import com.tweteroo.api.User;
import com.tweteroo.api.dto.tweetDTO;
import com.tweteroo.api.dto.userDTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping
public class Controller {
  
  private Controller() {
    //construtor implícito
  }

  @PostMapping("/sign-up")
  //@ResponseStatus(code = HttpStatus.OK, reason = "OK")
  public static String signup(@RequestBody @Valid userDTO req) {
    User.username = req.username();
    User.avatar = req.avatar();
    return "OK";
  }

  @PostMapping("/tweets")
  public static String createTweet(@RequestBody @Valid tweetDTO req) {
    TweetInfo newTweet = new TweetInfo(req.username(), User.avatar, req.tweet());
    TweetList.tweets.add(newTweet);
    return "OK";
  }
}