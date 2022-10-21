package com.kpoma.film.controller

import com.kpoma.film.model.Playlist
import com.kpoma.film.model.User
import com.kpoma.film.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(@Autowired val userService: UserService) {

    @PostMapping("add")
    fun addUser(@RequestBody user:User):User{
        return userService.addUser(user)
    }

    @GetMapping("/all")
    fun getUser():List<User>{
        return userService.getAllUser()
    }

    @GetMapping
    fun getUserByUsername(@Param(value = "username") username:String):User? {
        return userService.getUserByUserName(username)
    }

    @GetMapping("{id}")
    fun getUserById(@PathVariable id:Int):User? {
        return userService.getUserById(id)
    }

    @GetMapping("{id}/playslists")
    fun getPlayListByUser(@PathVariable id:Int):List<Playlist>? {
        return userService.getPlayListByUser(id)
    }

}