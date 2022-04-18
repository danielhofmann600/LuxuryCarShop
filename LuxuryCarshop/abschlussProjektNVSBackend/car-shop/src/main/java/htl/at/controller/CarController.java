package htl.at.controller;

import htl.at.model.Car;
import htl.at.model.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CarController implements PanacheRepository<Car> {

    @Inject
    CustomerController custRepo;

    public List<Car> getReservedCars(int customerId){
        Customer cust = custRepo.findById((long)customerId);
        return find("reservedBy",cust).stream().collect(Collectors.toList());
    }

    public List<Car> getBoughtCars(int customerId){
        Customer cust = custRepo.findById((long)customerId);
        return find("boughtBy",cust).stream().collect(Collectors.toList());
    }

    public List<Car> getAllAvailableCars() {
        var available = find("car_available", true).stream().collect(Collectors.toList());
        var notreserved = find("car_reserved",false).stream().collect(Collectors.toList());
        available.addAll(notreserved);
        return available;
    }
}
