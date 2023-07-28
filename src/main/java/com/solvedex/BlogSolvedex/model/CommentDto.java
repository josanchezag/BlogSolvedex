package com.solvedex.BlogSolvedex.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class CommentDto {
    private Long id;
    private Long idPost;
    private String content;
    private Integer idAuthor;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Integer idStatus;
}
