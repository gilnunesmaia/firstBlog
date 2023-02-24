package br.com.nunesmaia.fabiano.blog.controller;


import br.com.nunesmaia.fabiano.blog.model.Movie;
import br.com.nunesmaia.fabiano.blog.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/movie")
public class MovieController {


    private final MovieService ms;

    @RequestMapping("/film-list")
    public ModelAndView getMovie() {
        ModelAndView mv = new ModelAndView("list");
        List<Movie> ml = ms.findAll();
        mv.addObject("movielist", ml);
        return mv;
    }

}
