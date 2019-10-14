package com.restaurant.models;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "table_type")
public class TableType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableId;

    @Column(nullable = false)
    private int seatsNumber;

    @Column(nullable = false)
    private boolean availability;

    @ManyToOne
    private Restaurant restaurantId;

    @OneToMany(mappedBy = "reservationId")
    private Set<Reservation> reservationSet = new TreeSet<>();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof TableType){
            TableType tableType = (TableType) o;
            return tableId == tableType.tableId && seatsNumber == tableType.seatsNumber;
        }
        return false;
    }
}
