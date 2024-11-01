package com.example.android_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "danhmuc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @Column(name = "madanhmuc")
        private Long id;

        @Column(name = "tendanhmuc")
        private String name;
}
