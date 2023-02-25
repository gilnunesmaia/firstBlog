package br.com.nunesmaia.fabiano.blog.controller;


import br.com.nunesmaia.fabiano.blog.exception.YearUnfoundException;
import br.com.nunesmaia.fabiano.blog.model.Movie;
import br.com.nunesmaia.fabiano.blog.service.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/movie")
public class MovieController {


    private final MovieService ms;

    @GetMapping("/film-list")
    public ModelAndView getMovie() {
        ModelAndView mv = new ModelAndView("list");
        List<Movie> ml = ms.findAll();
        mv.addObject("movielist", ml);
        return mv;
    }

    @GetMapping("/new-movie")
    public String newMovie() {
        return "create";
    }

    @PostMapping("/new-movie")
    public String SavePost(@Valid Movie movie) throws YearUnfoundException {
        ms.save(movie);
        return "redirect:/movie/film-list";

    }

    @GetMapping("/read/{id}")
    public ModelAndView readMovie(@PathVariable("id") long id){
       ModelAndView mv = new ModelAndView("movie-details");
        Movie movie = ms.findById(id);
        System.out.println(movie);
        mv.addObject("movie", movie );
        return mv;

    }


}
