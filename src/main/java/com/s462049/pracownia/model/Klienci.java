package com.s462049.pracownia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "KLIENCI")
@Getter
@Setter
@NoArgsConstructor
public class Klienci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String clientName;
    @Column(nullable = false)
    private String miasto;


}
