package com.example.Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Management.entites.Rating;
import com.example.Management.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingService.createRating(rating));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAll(){
		return ResponseEntity.ok(this.ratingService.getAllRating());
	}
	
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable(name = "userId") String userId){
		return ResponseEntity.ok(this.ratingService.getRatingBytUserId(userId));
	}
	

	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(this.ratingService.getRatingBytHotelId(hotelId));
	}
	
	
}
