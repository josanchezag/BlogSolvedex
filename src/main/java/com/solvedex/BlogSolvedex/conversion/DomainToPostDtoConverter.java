package com.solvedex.BlogSolvedex.conversion;

import com.solvedex.BlogSolvedex.model.Post;
import com.solvedex.BlogSolvedex.model.PostDto;
import org.springframework.core.convert.converter.Converter;

public class DomainToPostDtoConverter implements Converter<Post, PostDto> {
    @Override
    public PostDto convert(Post source) {
        return PostDto.builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .idAuthor(source.getAuthor().getId())
                .created_at(source.getCreated_at())
                .updated_at(source.getUpdated_at())
                .idStatus(source.getStatus().getId())
                .build();
    }
}
