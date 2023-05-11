package com.example.Management.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Management.entites.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
}
