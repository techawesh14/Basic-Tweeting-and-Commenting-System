package com.Alemeno.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Alemeno.dto.Tweet;
import com.Alemeno.repo.TweetRepository;
@Repository
public class TweetDao {
	@Autowired
	private TweetRepository tweetRepository;
	
	public Tweet saveTweet(Tweet tweet) {
		return tweetRepository.save(tweet);
	}
	
	public Tweet updateTweet(Tweet tweet) {
		return tweetRepository.save(tweet);
	}

	public void deleteTweet(int id) {
		tweetRepository.deleteById(id);
	}

	public Optional<Tweet> getTweet(int id) {
		return tweetRepository.findById(id);
	}

	public List<Tweet> getAll() {
		return tweetRepository.findAll();
	}

}
