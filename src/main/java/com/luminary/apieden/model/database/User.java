package com.luminary.apieden.model.database;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
@Schema(name = "UserSchema", description = "Schema of users")
public class User {

    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private long id;

    @Column(name = "cpf", nullable = false, unique = true)
    @NotBlank(message = "O campo 'cpf' deve ser passado")
    @CPF(message = "O campo 'cpf' é inválido")
    @Schema(name = "cpf", description = "The cpf of the user", example = "42391552076")
    private String cpf;

    @Column(name = "name")
    @NotBlank(message = "O campo 'name' deve ser passado")
    @Size(message = "'name' passa o limite de 45 caracteres", max = 45)
    @Schema(name = "name", description = "The name of the user", example = "Pedro Moisés")
    private String name;

    @Column(name = "user_name")
    @NotBlank(message = "O campo 'userName' deve ser passado")
    @Size(message = "'userName' passa do limite de 45 caracteres", max = 45)
    @Schema(name = "userName", description = "The user name of the app", example = "pedro.gusmao")
    private String userName;

    @Column(name = "password")
    @NotBlank(message = "O campo 'password' deve ser passado")
    @Schema(name = "password", description = "The password of the user", example = "megaSenha@123")
    private String password;

    @Column(name = "rating")
    @Schema(name = "rating", description = "The rating of the user", example = "3.5")
    private float rating;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "O campo 'email' deve ser passado")
    @Email(message = "O campo 'email' é inválido")
    @Size(message = "Email ultrapassa o limite máximo", max = 90)
    @Schema(name = "email", description = "The email of the user", example = "pedro.pedro@mail.com")
    private String email;

    @Column(name = "cellphone", unique = true)
    @Size(message = "O campo 'cellphone' tem que ter 11 digítos", min = 11, max = 11)
    @Schema(name = "cellphone", description = "The phone of the user", example = "11400289220")
    private String cellphone;
}
