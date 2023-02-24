package br.com.nunesmaia.fabiano.blog.service;

import br.com.nunesmaia.fabiano.blog.exception.YearUnfoundException;
import br.com.nunesmaia.fabiano.blog.model.Movie;
import br.com.nunesmaia.fabiano.blog.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {


    private final MovieRepository repository;

    public Movie save(Movie movie) throws YearUnfoundException {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        if (movie.getAnoDeLancamento() < 1900 || movie.getAnoDeLancamento() > year){
            throw new YearUnfoundException();
        }

        return repository.save(movie);
    }

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Movie findById(Long id){
        return repository.findById(id).get();
    }




}
