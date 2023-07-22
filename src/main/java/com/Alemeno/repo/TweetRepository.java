package com.Alemeno.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Alemeno.dto.Tweet;
public interface TweetRepository extends JpaRepository<Tweet, Integer>{

}
