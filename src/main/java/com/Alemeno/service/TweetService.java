package com.Alemeno.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Alemeno.dao.TweetDao;
import com.Alemeno.dao.UserDao;
import com.Alemeno.dto.ResponseStructure;
import com.Alemeno.dto.Tweet;
import com.Alemeno.dto.User;
import com.Alemeno.exception.IdNotFoundException;
@Service
public class TweetService {
	@Autowired
	private TweetDao tweetDao;
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Tweet>> saveTweet(Tweet tweet, int uid) {
		Optional <User> user=userDao.getUser(uid);
		ResponseStructure<Tweet> structure= new ResponseStructure<Tweet>();
		
		if(user.isPresent()) {
			tweet.setUser(user.get());
			user.get().getTweets().add(tweet);
			structure.setBody(tweetDao.saveTweet(tweet));
			structure.setMessage("saved sucessfully");
			structure.setCode(HttpStatus.ACCEPTED.value());
			
		}else {
			throw new IdNotFoundException();
		}
		
		return new ResponseEntity<ResponseStructure<Tweet>>(structure, HttpStatus.ACCEPTED);

	}
	
	public ResponseEntity<ResponseStructure<Tweet>> updateTweet(Tweet tweet, int uid) {
		ResponseStructure<Tweet> structure = new ResponseStructure<Tweet>();

		structure.setBody(tweetDao.updateTweet(tweet));
		structure.setMessage("Saved Successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());

		return new ResponseEntity<ResponseStructure<Tweet>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteTweet(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		Optional<Tweet> op = tweetDao.getTweet(id);
		if (op.isPresent()) {
			tweetDao.deleteTweet(id);;

			structure.setBody("User Present");
			structure.setMessage("Deleted Successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	
	public ResponseEntity<ResponseStructure<Tweet>> getTweet(int id) {
		ResponseStructure<Tweet> structure = new ResponseStructure<Tweet>();

		Optional<Tweet> op = tweetDao.getTweet(id);
		if (op.isPresent()) {
			structure.setBody(op.get());
			structure.setMessage("Id is present");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<Tweet>>(structure, HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<List<Tweet>>> getAll() {
		ResponseStructure<List<Tweet>> structure = new ResponseStructure<List<Tweet>>();
		structure.setBody(tweetDao.getAll());
		structure.setMessage("Records are fetched");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Tweet>>>(structure, HttpStatus.FOUND);
	}
	
	
	
}
