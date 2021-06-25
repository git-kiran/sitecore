package com.example.sitecore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ROUTE")
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "DEPARTURE_CODE")
    private String departure;
    @Column(name = "ARRIVAL_CODE")
    private String arrival;
    @Column(name = "DURATION")
    private int distance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
