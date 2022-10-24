package com.kpoma.film.controller

import com.kpoma.film.model.Film
import com.kpoma.film.service.FilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.query.Param
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/films")
class FilmController(
    @Autowired
    private val filmService: FilmService
) {
    @GetMapping("/all")
    fun getFilms(): List<Film>{
        return filmService.getAllFilm()
    }

    @GetMapping("/annee")
    fun getFilmsByYear(@Param(value = "annee") annee:Int): List<Film>?{
        return filmService.getFilmsByYear(annee)
    }


    @GetMapping("{id}")
    fun getFilmById(@PathVariable id:Int): Film? {
        return filmService.getFilmById(id)
    }

    @GetMapping
    fun getFilmByName(@Param(value = "name") name:String): Film? {
        return filmService.getFilmByName(name)
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    fun addFilm(@RequestBody film: Film):Film? {
        return filmService.addFilm(film)
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("update/{id}")
    fun updateFilm(@PathVariable id: Int, @RequestBody film: Film):Film? {
        film.id=id
        return filmService.addFilm(film)
    }
}