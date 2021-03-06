package com.s462049.pracownia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Komisy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Komisy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String nazwaKomisu;
    @Column(nullable = false)
    private String miasto;
    @ManyToMany
    @JoinTable(name="Komis_Klienci",joinColumns = @JoinColumn(name="Komisy_ID"),inverseJoinColumns = @JoinColumn(name="Klienci_ID"))
    private Set<Klienci> Klienci;
}
