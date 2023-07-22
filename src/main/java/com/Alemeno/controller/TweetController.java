package com.Alemeno.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Alemeno.dto.ResponseStructure;
import com.Alemeno.dto.Tweet;
import com.Alemeno.service.TweetService;

@RestController
public class TweetController {
	@Autowired
	private TweetService tweetService;
	
	@PostMapping("/tweet/{uid}")
	public ResponseEntity<ResponseStructure<Tweet>> saveTweet(@RequestBody Tweet tweet, @PathVariable int uid) {
		return tweetService.saveTweet(tweet, uid);
	}

	@PutMapping("/tweet/{uid}")
	public ResponseEntity<ResponseStructure<Tweet>> updateTweet(@RequestBody Tweet tweet , @PathVariable int uid) {
		return tweetService.updateTweet(tweet,uid);
	}

	@DeleteMapping("/tweet/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteTweet(@PathVariable int id) {
		return tweetService.deleteTweet(id);
	}

	@GetMapping("/tweet/{id}")
	public ResponseEntity<ResponseStructure<Tweet>> getTweet(@PathVariable int id) {
		return tweetService.getTweet(id);
	}

	@GetMapping("/tweet/all")
	public ResponseEntity<ResponseStructure<List<Tweet>>> getAll() {
		return tweetService.getAll();
	}

	
	

}
