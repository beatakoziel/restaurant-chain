package com.restaurant.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private double bill;

    @OneToOne
    private Reservation reservation;

    @ManyToOne
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "order_menu")
    private List<Menu> orderDishes = new ArrayList<>();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Order){
            Order order = (Order) o;
            return orderId == order.orderId && bill == order.bill;
        }
        return false;
    }

}
