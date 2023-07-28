package com.solvedex.BlogSolvedex.model;

import com.solvedex.BlogSolvedex.constants.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private Integer idAuthor;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Integer idStatus;
}
