package com.solvedex.BlogSolvedex.model;

import com.solvedex.BlogSolvedex.constants.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEG_COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Userg author;

    @Column(name = "CREATE_AT")
    private LocalDateTime created_at;

    @Column(name = "UPDATE_AT")
    private LocalDateTime updated_at;

    @Column(name = "STATUS", nullable = false)
    private StatusEnum status;


    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now();
    }
}
