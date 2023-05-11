package com.example.Management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Management.Repo.RatingRepository;
import com.example.Management.entites.Rating;
import com.example.Management.service.RatingService;

@Service
public class RatingImpl implements RatingService  {

	@Autowired
	RatingRepository ratingRepository;
	
	
	@Override
	public Rating createRating(Rating rating) {
		return 	this.ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {	 
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingBytUserId(String userId) {
		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingBytHotelId(String hotelId) {
		return this.ratingRepository.findByHotelId(hotelId);
	}

	
}
