package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.PersonDTO;
import com.tweteroo.api.dto.tweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.services.PersonService;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class Controller {
  @Autowired
  private PersonService userService;

  @Autowired
  private TweetService tweetService;

  private Controller() {
  }

  @PostMapping("/sign-up")
  public String signup(@RequestBody @Valid PersonDTO req) {
    userService.save(req);
    return "OK";
  }

  @PostMapping("/tweets")
  public String createTweet(@RequestBody @Valid tweetDTO req) {
    tweetService.save(req);
    return "OK";
  }

  @GetMapping("/tweets")
  public ResponseEntity<Page<Tweet>> list(@PageableDefault(size = 5, page = 0) Pageable pageable) {
    return ResponseEntity.ok(tweetService.listAll(pageable));
  }

}