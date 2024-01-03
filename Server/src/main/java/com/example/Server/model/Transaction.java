package com.example.Server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "transaction")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String type;

    @Column
    private String category;

    @Column
    private double amount;

    @Column
    private Date timestamp;

}
