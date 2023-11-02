package mk.finki.ukim.mk.lab.Service;

import mk.finki.ukim.mk.lab.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> listAll();
    List<Movie> searchMovies(String text);
}
