package com.spring.fooddelivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fooddeliverydb")
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "pavadinimas")
    private String pavadinimas;

    @Column(name = "pastokodas")
    private String pastokodas;

    @Column(name = "adresas")
    private String adresas;

    @Column(name = "maistas")
    private String maistas;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User users;

    public Number(String pavadinimas, String pastokodas, String adresas, String maistas) {
        this.pavadinimas = pavadinimas;
        this.pastokodas = pastokodas;
        this.adresas = adresas;
        this.pastokodas = pastokodas;
        this.maistas = maistas;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", pavadinimas=" + pavadinimas +
                ", pastokodas=" + pastokodas +
                ", adresas='" + adresas  +
                ", maistas=" + maistas + '\'' +
                '}';
    }
}
