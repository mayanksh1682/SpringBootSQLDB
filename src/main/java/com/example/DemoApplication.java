package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.repositories.UserRepository;

@SpringBootApplication
@RestController
public class DemoApplication {
	
	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/save")
	List<User> save() {
		User user1 = new User("Alice", 23);
		User user2 = new User("Bob", 38);
		// save user, verify has ID value after save

		userRepo.save(user1);
		userRepo.save(user2);
		System.out.println("User1 Identity "+user1.getId());
		System.out.println("User2 Identity "+user1.getId());
		Stream<User>  stream = Stream.of(user1,user2);
		return stream.collect(Collectors.toList());
	}

	@RequestMapping("/fetch")
	String fetch() {
		return "";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
