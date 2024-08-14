package com.neo.resources;

import com.neo.kafka.MovieProducer;
import com.neo.models.Movie;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    @Inject
    MovieProducer producer;

    @POST
    @Path("addMovie")
    public Response sendMovie(Movie movie){
        producer.sendMovieToKafka(movie);
        return Response.accepted().build();
    }

    @POST
    @Path("addShow")
    public Response send(Movie movie){
        producer.sendShowToKafka(movie);
        return Response.accepted().build();
    }

}
