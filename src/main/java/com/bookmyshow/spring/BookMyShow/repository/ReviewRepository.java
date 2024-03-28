package com.bookmyshow.spring.BookMyShow.repository;

import com.bookmyshow.spring.BookMyShow.collectionsTables.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
