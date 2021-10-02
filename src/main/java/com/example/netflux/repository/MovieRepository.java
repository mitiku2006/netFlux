package com.example.netflux.repository;

import com.example.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
