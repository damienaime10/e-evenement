package com.example.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;


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

	@ManyToMany
	@JoinTable(
			name = "comment_publier",
			joinColumns = @JoinColumn(name = "comment_id"),
			inverseJoinColumns = @JoinColumn(name = "publier_id")
	)
	private Set<Publier> publiers;


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