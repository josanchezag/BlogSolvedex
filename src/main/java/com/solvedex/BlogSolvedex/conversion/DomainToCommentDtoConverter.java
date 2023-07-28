package com.solvedex.BlogSolvedex.conversion;

import com.solvedex.BlogSolvedex.model.Comment;
import com.solvedex.BlogSolvedex.model.CommentDto;
import org.springframework.core.convert.converter.Converter;

public class DomainToCommentDtoConverter implements Converter<Comment, CommentDto> {
    @Override
    public CommentDto convert(Comment source) {
        return CommentDto.builder()
                .id(source.getId())
                .idPost(source.getPost().getId())
                .content(source.getContent())
                .idAuthor(source.getAuthor().getId())
                .created_at(source.getCreated_at())
                .updated_at(source.getUpdated_at())
                .idStatus(source.getStatus().getId())
                .build();
    }
}
