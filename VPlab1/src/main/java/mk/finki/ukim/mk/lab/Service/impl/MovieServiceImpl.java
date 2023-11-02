package mk.finki.ukim.mk.lab.Service.impl;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.Repository.MovieRepository;
import mk.finki.ukim.mk.lab.Service.MovieService;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public List<Movie> listAll()
    {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text)
    {
        return movieRepository.searchMovies(text);
    }
}
