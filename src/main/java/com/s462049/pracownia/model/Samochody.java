package com.s462049.pracownia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String nazwaSamochodu;
    @Column(nullable = false)
    private String przebieg;
    @ManyToOne
    private Komisy Komis;
}
