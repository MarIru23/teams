package es.laguna.teams.Models;
//El primer import se pone * para el @ID
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

//Esto se pone siempre
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private UUID uuid;
    private String name;
    private String country;
    private String stadium;
    private Boolean champions;
    //Se establece la relacion de un equipo para muchos jugadores
    @OneToMany
    private List<Player> players;


}
//El siguiente es el repositories