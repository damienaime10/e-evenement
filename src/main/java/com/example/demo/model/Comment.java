package com.example.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nonnull
	private Long commentId;
	
	@Column
	@Nonnull
	private String commentaire;

    @Column
	@Nonnull
	private String nom;


    @ManyToOne
    private Event event;

	@Column
	@Nonnull
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	@PrePersist
	protected  void onCreated(){
		created_at=new Date();
	}
		
	
	

	

}