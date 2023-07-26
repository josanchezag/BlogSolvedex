package com.solvedex.BlogSolvedex.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEG_USERS")
public class Userg {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "USERNAME", nullable = false)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String pass;

    @Column(name = "DS_COMPLETENAME", nullable = false)
    private String dsCompleteName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "DATE_SING_UP", nullable = false)
    private Date dateSingUp;

    @Column(name = "DATE_SING_DOWN")
    private Date dateSignDown;

    @Column(name = "SN_ACTIVE", nullable = false)
    private String snActive;

    @ManyToOne
    @JoinColumn(name = "ID_ROLE", nullable = false)
    private Role role;


}
