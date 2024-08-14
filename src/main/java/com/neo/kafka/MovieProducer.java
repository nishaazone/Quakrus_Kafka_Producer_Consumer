package com.neo.kafka;

import com.neo.models.Movie;
import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class MovieProducer {

    @Inject
    @Channel("movies-out")
    Emitter<Record<Integer, String>> MovieEmitter;

    @Inject
    @Channel("movies-out-2")
    Emitter<Record<Integer, String>> ShowEmitter;

    public void sendMovieToKafka(Movie movie) {
        MovieEmitter.send(Record.of(movie.year, movie.title));
    }

    public void sendShowToKafka(Movie movie) {
        ShowEmitter.send(Record.of(movie.year, movie.title));
    }
}
