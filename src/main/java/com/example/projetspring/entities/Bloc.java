package com.example.projetspring.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idBloc")
public class Bloc implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;
    //@JsonManagedReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Foyer foyer;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Chambre> chambre;
}






