package com.example.demo.DTO;



import lombok.Data;

import java.util.Date;

@Data
public class EventDTO {

    private String eventTitle;

    private String eventDescription;

    private String location;

    private String contact;

    private String email;

    private String leaderName;

    private String photo;

    private Date eventDate;

    public EventDTO() {
    }

    public EventDTO(String eventTitle, String eventDescription, String location, String contact, String email, String leaderName, String photo, Date eventDate) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.location = location;
        this.contact = contact;
        this.email = email;
        this.leaderName = leaderName;
        this.photo = photo;
        this.eventDate = eventDate;
    }


}
