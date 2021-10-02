package com.example.netflux.bootstrap;

import com.example.netflux.domain.Movie;
import com.example.netflux.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class initMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(Flux.just("movie1", "movie2", "movie3", "movie4", "movie5", "movie6", "movie7")
                        .map(Movie::new)
                        .flatMap(movieRepository::save)
                ).subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
