package br.com.nunesmaia.fabiano.blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@Table(name="TB_MOVIE")
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String tituo;

    @Enumerated(EnumType.STRING)
    private GenreEnum genero;

    @NotNull
    private int anoDeLancamento;



}
