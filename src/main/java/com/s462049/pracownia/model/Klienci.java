package com.s462049.pracownia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Klienci")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Klienci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String Client_name;
    @Column(nullable = false)
    private String Miasto;


}
