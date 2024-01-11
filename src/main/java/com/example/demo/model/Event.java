package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nonnull
	private Long eventId;
	
	@Column
	@Nonnull
	private String eventTitle;

    @Column
	@Nonnull
	private String eventDescription;

    @Column
	@Nonnull
	private String location;

    @Column
	@Nonnull
	private String contact;

    @Column
	private String email;

    @Column
	@Nonnull
	private String leaderName;

	@Column
	private String photo;

    @Column
	private Integer participantNumber;

    @ManyToOne
    private Publier publier;
	
	@Column
	@Nonnull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;

	@Column
	@Nonnull
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	@PrePersist
	protected  void onCreated(){
		created_at=new Date();
	}





}