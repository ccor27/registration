package com.example.registration.token;

import com.example.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @SequenceGenerator(
            name="confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence    "
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAT;

    @Column(nullable = false)
    private LocalDateTime expiresAT;

    private LocalDateTime confirmedAT;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;

    public ConfirmationToken(String token, LocalDateTime createdAT, LocalDateTime expiresAT,AppUser appUser) {

        this.token = token;
        this.createdAT = createdAT;
        this.expiresAT = expiresAT;
        this.appUser=appUser;
    }
}
