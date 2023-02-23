package br.com.nunesmaia.fabiano.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String genero;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private String anoDeLancamento;



}
