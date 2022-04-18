package htl.at.controller;

import htl.at.model.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerController implements PanacheRepository<Customer> {

}
