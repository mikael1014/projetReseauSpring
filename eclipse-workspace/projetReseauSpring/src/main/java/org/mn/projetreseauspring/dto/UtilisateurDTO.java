package org.mn.projetreseauspring.dto;

import lombok.*;

import org.mn.projetreseauspring.entiy.enum_.RoleUtilisateur;
import org.mn.projetreseauspring.validation.FieldMatch;
import org.mn.projetreseauspring.validation.Password;
import org.mn.projetreseauspring.validation.ValidEmail;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldMatch.List({
        @FieldMatch(first = "password", second = "passwordConfirmation", message = "Password fields must match")
})
public class UtilisateurDTO {

    private Long id;

    @NotNull
    @ValidEmail
	private String login;//email

    @NotNull
    @Size(min=6, max=100, message = "Min size is 6 and max size is 100")
    @Password
    private String password;

    @NotNull
    @Size(min=6, max=100, message = "Min size is 6 and max size is 100")
    private String passwordConfirmation;

    @NotNull
    @Size(min=2, max=100, message = "Min size is 2 and max size is 100")
    private String nom;

    @NotNull
    @Size(min=2, max=100, message = "Min size is 2 and max size is 100")
    private String prenom;

    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate ddn;

    private String sexe;
    private String telephone;
	private RoleUtilisateur roleUtilisateur;//private Boolean isAdmin;
    private String avatar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurDTO user = (UtilisateurDTO) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
