package com.s462049.pracownia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Samochody")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Samochody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String Nazwa_samochodu;
    @Column(nullable = false)
    private String Przebieg;
    @ManyToOne
    private Komisy Komis;
}
