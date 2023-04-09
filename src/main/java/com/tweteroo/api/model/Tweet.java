package com.tweteroo.api.model;

import com.tweteroo.api.dto.tweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {
  public Tweet(tweetDTO tweetData, String username, String avatar) {
    this.username = username;
    this.avatar = avatar;
    this.tweet = tweetData.tweet();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String username;

  @Column(length = 200, nullable = false)
  private String avatar;

  @Column(length = 200, nullable = false)
  private String tweet;
}
