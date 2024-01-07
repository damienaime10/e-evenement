package com.example.demo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	@Nonnull
	private String email;

    @Column
	@Nonnull
	private String leaderName;

	@Column
	private String photo;

    @Column
	@Nonnull
	private Integer participantNumber;

    @ManyToOne
    private Publier publier;
	
	@Column
	@Nonnull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	
	
	

	

}