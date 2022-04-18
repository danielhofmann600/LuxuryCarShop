package htl.at.endpoints;

import htl.at.controller.CarController;
import htl.at.model.Car;
import htl.at.model.Customer;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataEndpoint {

    @Inject
    CarController carRepo;

    @DELETE
    @Path("/{carId}/reservedBy/{custId}")
    @Transactional
    public Response reserve(@PathParam("carId") String carId, @PathParam("custId") String custId) {
        Car car = Car.findById(Long.parseLong(carId));
        Customer customer = Customer.findById(Long.parseLong(custId));
        if(car == null) {
            throw new NotFoundException();
        }
        car.isReserved = !car.isReserved;
        if(!car.isReserved){
            car.reservedBy = null;
            return Response.ok().build();
        }
        car.reservedBy = customer;
        return Response.ok().build();
    }



    @DELETE
    @Path("/{carId}/boughtBy/{custId}")
    @Transactional
    public Response buy(@PathParam("carId") String carId, @PathParam("custId") String custId) {
        Car car = Car.findById(Long.parseLong(carId));
        Customer customer = Customer.findById(Long.parseLong(custId));
        if(car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        car.isAvailable = false;
        car.isReserved = false;
        car.boughtBy = customer;
        car.reservedBy = null;
        return Response.ok().build();
    }

    @GET
    @Path("/reservedBy/{Id}")
    public List<Car> getReservedCars(@PathParam("Id") String Id){
        return carRepo.getReservedCars(Integer.parseInt(Id));
    }

    @GET
    @Path("/boughtBy/{Id}")
    public List<Car> getBoughtCars(@PathParam("Id") String Id){
        return carRepo.getBoughtCars(Integer.parseInt(Id));
    }

    @GET
    public List<Car> getCars(){
        return carRepo.getAllAvailableCars();
    }


}
