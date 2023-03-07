package com.arg.ecommerce.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


import java.io.Serializable;

@Entity
@Data
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @NotEmpty
    private String name;

    private String description;

    @NotEmpty
    private String category;

    private float price;

    private int discountId;

    @NotEmpty
    private String imgLink;










}
