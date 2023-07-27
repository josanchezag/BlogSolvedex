package com.solvedex.BlogSolvedex.model;

import com.solvedex.BlogSolvedex.constants.StatusEnum;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEG_POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

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
    @Enumerated(EnumType.ORDINAL)
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
