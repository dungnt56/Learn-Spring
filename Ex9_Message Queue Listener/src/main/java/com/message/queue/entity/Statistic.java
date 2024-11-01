package com.message.queue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@ToString
@Table(name = "tbl_statistic")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name = "warehouse_id")
    private long warehouseId;

    @NotNull
    @Column(name = "number_of_product")
    private long numberOfProduct;

    @NotNull
    @Column(name = "statistic_day")
    private String statisticDay;
}
