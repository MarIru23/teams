package es.laguna.teams.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//Primero va el models, luego el repositories, luego el service, luego el controller
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String name;
    private Integer number;
    //Se establece la relacion de muchos jugadores para un equipo
    @ManyToOne
    private Team team;
}
// No se mete el team_Id por que ya se tiene como inicializado en el private Team team