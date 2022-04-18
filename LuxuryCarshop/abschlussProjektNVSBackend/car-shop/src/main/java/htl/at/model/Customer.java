package htl.at.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.jboss.resteasy.spi.touri.MappedBy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customer", schema = "car_shop")
public class Customer extends PanacheEntity {

    @Column(name = "cust_alias")
    public String username;
    @Column(name = "cust_pwdhash")
    public String password;
    @Column(name = "cust_credibility")
    public String credibility;//can be high = 2, average = 1 or low = 0

    @OneToMany(mappedBy = "reservedBy")
    @JsonManagedReference
    public List<Car> reservedCars;

    @OneToMany(mappedBy = "boughtBy")
    @JsonManagedReference
    public List<Car> boughtCars;

}
