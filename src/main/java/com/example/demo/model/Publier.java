package com.example.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="publiers")
public class Publier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nonnull
	private Long publierId;
	
	@Column
	@Nonnull
	private String nom;

    @Column
	@Nonnull
	private String contact;

    @Column
	@Nonnull
	private String email;

    @Column
	@Nonnull
	private String logo;

    @Column
	@Nonnull
	private String password;

    @Column
	@Nonnull
	private String description;

    @Column
	@Nonnull
	private Integer statut;	

	

}