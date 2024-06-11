package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Audited
public class Domicilio extends Base {
    private String calle;
    private Integer numero;
    private Integer cp;
    private Integer piso;
    private Integer nroDpto;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "localidad_id")
    @NotAudited
    private Localidad localidad;

    @ManyToMany(mappedBy = "domicilios")
    @Builder.Default
    private Set<Cliente> clientes = new HashSet<>();
}
