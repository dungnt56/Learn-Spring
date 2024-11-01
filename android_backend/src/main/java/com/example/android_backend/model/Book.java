package com.example.android_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "sach")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "masach")
    private Long id;

    @Column(name = "tieude")
    private String title;

    @Column(name = "tacgia")
    private String author;

    @Column(name = "namxuatban")
    private Integer publishedYear;

    @Column(name = "mota")
    private String description;

    @Column(name = "hinhanh")
    private String image;

    @Column(name = "madanhmuc")
    private Long categoryId;

}
