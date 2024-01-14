package com.example.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
//@AllArgsConstructor
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;

	@Column
	private Boolean statut;
	@PrePersist
	protected  void onCreated(){
		created_at=new Date();
		statut=false;
	}


	public Publier(@Nonnull String nom, @Nonnull String contact, @Nonnull String email, @Nonnull String logo, @Nonnull String password, @Nonnull String description) {
		this.nom = nom;
		this.contact = contact;
		this.email = email;
		this.logo = logo;
		this.password = password;
		this.description = description;
	}


	@Override
	public String toString() {
		return "Publier{" +
				"publierId=" + publierId +
				", nom='" + nom + '\'' +
				", contact='" + contact + '\'' +
				", email='" + email + '\'' +
				", logo='" + logo + '\'' +
				", password='" + password + '\'' +
				", description='" + description + '\'' +
				", statut=" + statut +
				'}';
	}
}