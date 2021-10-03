package com.example.netflux.controlers;

import com.example.netflux.domain.Movie;
import com.example.netflux.domain.MovieEvent;
import com.example.netflux.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    public Mono<Movie> getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    public Flux<Movie> getMovieAll() {
        return movieService.findAllMovies();
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvent> getStreamMovieById(@PathVariable String id) {
        return movieService.streamMovieEvents(id);
    }


}
