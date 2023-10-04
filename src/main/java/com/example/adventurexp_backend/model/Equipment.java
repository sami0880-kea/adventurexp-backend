package com.example.adventurexp_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipmentId;
    private String equipmentName;
    private int equipmentAmountId;

    @OneToOne
    @JoinColumn(name = "activity", referencedColumnName = "id")
    private Activity activity;
}
