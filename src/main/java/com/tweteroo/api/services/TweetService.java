package com.tweteroo.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.tweetDTO;
import com.tweteroo.api.model.Person;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repositories.PersonRepository;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {

  @Autowired
  private TweetRepository repository;

  @Autowired
  private PersonRepository userRepository;

  public void save(tweetDTO tweet) {

    Optional<Person> user = userRepository.findByUsername(tweet.username());

    if (user.isPresent()) {
      repository.save(new Tweet(tweet, user.get().getUsername(), user.get().getAvatar()));
    }

  }

  public Page<Tweet> listAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public List<Tweet> findByUsername(String username) {
    List<Tweet> list = repository.findAll();
    List<Tweet> listWithUsername = new ArrayList<>();

    for (Tweet tweet : list) {
      if (tweet.getUsername().equals(username)) {
        listWithUsername.add(tweet);
      }
    }

    return listWithUsername;
  }

}