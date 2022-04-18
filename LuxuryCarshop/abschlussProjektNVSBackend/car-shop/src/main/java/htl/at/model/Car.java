package htl.at.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "car", schema = "car_shop")
public class Car extends PanacheEntity {

    @Column(name = "car_horespower")
    public int horsepower;
    @Column(name = "car_colour")
    public String colour;
    @Column(name = "car_model")
    public String carModel;
    @Column(nullable = false, name = "car_type")
    public String carType;
    @Column(name = "car_reserved")
    public boolean isReserved = false;
    @Column(name = "car_available")
    public boolean isAvailable = true;


    @ManyToOne
    @JoinColumn(name = "car_reserver", nullable = true)
    @JsonBackReference
    public Customer reservedBy;

    @ManyToOne
    @JoinColumn(name = "car_buyer", nullable = true)
    @JsonBackReference
    public Customer boughtBy;

}
