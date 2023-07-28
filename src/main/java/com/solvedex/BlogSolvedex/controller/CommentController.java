package com.solvedex.BlogSolvedex.controller;

import com.solvedex.BlogSolvedex.constants.StatusEnum;
import com.solvedex.BlogSolvedex.model.Comment;
import com.solvedex.BlogSolvedex.model.CommentDto;
import com.solvedex.BlogSolvedex.model.Post;
import com.solvedex.BlogSolvedex.model.PostDto;
import com.solvedex.BlogSolvedex.services.ICommentService;
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
@RequestMapping("/Comments")
@AllArgsConstructor
public class CommentController {
    private final ConversionService conversionService;
    @Autowired
    ICommentService commentService;

    @Autowired
    IUserService userService;

    @GetMapping("/ListComments")
    public List<CommentDto> getAll() {
        return commentService
                .findAll()
                .stream()
                .map(comment -> conversionService.convert(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/ListComments/{commentId}")
    public ResponseEntity<CommentDto> getById(@PathVariable Long commentId) throws Exception {
        return commentService.findById(commentId)
                .map(comment -> conversionService.convert(comment, CommentDto.class))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Doesn't exist a comment with Id: "+commentId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CommentDto> save(@RequestBody Comment savedComment) throws Exception {
        return   commentService.save(savedComment)
                .map(comment -> conversionService.convert(comment, CommentDto.class))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Error at save a new comment"));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updatePost(@PathVariable Long commentId, @RequestBody Post savedComment) throws Exception {
        return commentService.save(commentService.findById(commentId)
                .orElseThrow(() -> new Exception("")))
                .map(comment -> conversionService.convert(comment, CommentDto.class))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Error at update a comment"));
    }

    @PatchMapping("/{commentId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CommentDto> updatePartialPost(@PathVariable Long commentId, @RequestBody Comment updatedComment) throws Exception {
        Comment existingComment = commentService.findById(commentId).orElse(null);
        if (existingComment != null) {
            existingComment.setPost(updatedComment.getPost());
            existingComment.setContent(updatedComment.getContent());
            existingComment.setAuthor(userService.findOneByuserName(updatedComment
                                                                    .getAuthor()
                                                                    .getUserName())
                                                                    .orElseThrow());
            existingComment.setStatus(StatusEnum.getById(updatedComment.getStatus().getId()));
            return commentService.save(existingComment)
                    .map(comment -> conversionService.convert(comment, CommentDto.class))
                    .map(ResponseEntity::ok)
                    .orElseThrow(() -> new Exception("Error at update a comment"));
        } else {
            new Exception("Doesn't exist a Post with Id: "+commentId);
        }
        return null;
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePost(@PathVariable Long commentId) throws Exception {
        commentService.deleteById(commentId);
        return ResponseEntity.noContent().build();
    }
}
