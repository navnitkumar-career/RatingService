package com.example.Management.service;

import java.util.List;

import com.example.Management.entites.Rating;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public interface RatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingBytUserId(String userId);
	
	
	List<Rating> getRatingBytHotelId(String hotelId);
	
	
	
	

}
