package com.solvedex.BlogSolvedex.controller;

import com.solvedex.BlogSolvedex.model.Post;
import com.solvedex.BlogSolvedex.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Posts")
public class PostController {
    @Autowired
    IPostService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post insertClient(@RequestBody Post p) {
        return service.save(p);
    }
}
