package com.solvedex.BlogSolvedex.controller;

import com.solvedex.BlogSolvedex.constants.StatusEnum;
import com.solvedex.BlogSolvedex.model.Post;
import com.solvedex.BlogSolvedex.model.PostDto;
import com.solvedex.BlogSolvedex.services.IPostService;
import com.solvedex.BlogSolvedex.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Posts")
@AllArgsConstructor
public class PostController {
    private final ConversionService conversionService;
    @Autowired
    IPostService postService;

    @Autowired
    IUserService userService;

    @GetMapping("/ListPosts")
    public List<PostDto> getAll() {
        return postService
                .findAll()
                .stream()
                .map(post -> conversionService.convert(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/ListPosts/{postId}")
    public ResponseEntity<PostDto> getById(@PathVariable Long postId) throws Exception {
        return postService.findById(postId)
                .map(post -> conversionService.convert(post, PostDto.class))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Doesn't exist a Post with Id: "+postId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PostDto> save(@RequestBody Post savedPost) throws Exception {
        return   postService.save(savedPost)
                .map(post -> conversionService.convert(post, PostDto.class))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Error at save a new post"));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long postId, @RequestBody Post savedPost) throws Exception {
        return postService.save(postService.findById(postId)
                .orElseThrow(() -> new Exception("")))
                .map(post -> conversionService.convert(post, PostDto.class))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Error at update a post"));
    }

    @PatchMapping("/{postId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<PostDto> updatePartialPost(@PathVariable Long postId, @RequestBody Post updatedPost) throws Exception {
        Post existingPost = postService.findById(postId).orElse(null);
        if (existingPost != null) {
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            existingPost.setAuthor(userService.findOneByuserName(updatedPost
                                                                    .getAuthor()
                                                                    .getUserName())
                                                                    .orElseThrow());
            existingPost.setStatus(StatusEnum.getById(updatedPost.getStatus().getId()));
            return postService.save(existingPost)
                    .map(post -> conversionService.convert(post, PostDto.class))
                    .map(ResponseEntity::ok)
                    .orElseThrow(() -> new Exception("Error at update a post"));
        } else {
            new Exception("Doesn't exist a Post with Id: "+postId);
        }
        return null;
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) throws Exception {
        postService.deleteById(postId);
        return ResponseEntity.noContent().build();
    }
}
