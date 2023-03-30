package com.example.finalprojectspringcarrent.components;

import com.example.finalprojectspringcarrent.exceptions.AuthorityNotFoundException;
import com.example.finalprojectspringcarrent.exceptions.BranchNotFoundException;
import com.example.finalprojectspringcarrent.exceptions.CarNotFoundException;
import com.example.finalprojectspringcarrent.exceptions.UserNotFoundException;
import com.example.finalprojectspringcarrent.models.Authority;
import com.example.finalprojectspringcarrent.models.Branch;
import com.example.finalprojectspringcarrent.models.Car;
import com.example.finalprojectspringcarrent.models.User;
import com.example.finalprojectspringcarrent.services.AuthorityService;
import com.example.finalprojectspringcarrent.services.BranchService;
import com.example.finalprojectspringcarrent.services.CarService;
import com.example.finalprojectspringcarrent.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Tiina Raudla
 * @Date
 */
@Component
public class DataInit {
    @Autowired
    private BranchService branchService;

    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;


    @PostConstruct
    public void init() {
        initBranch();
        initCar();
        initUser();
        initBooking();
        initAuthority();
    }
    private  void initBranch(){
        System.out.println("Starting Branch initialization...");
        Branch branch = new Branch();
        branch.setAddress("Tallinn");

        try {
            Branch searchBranch = branchService.findBranchByAddress(branch.getAddress());
            System.out.println("Cannot pre-initialize school: " + branch.getAddress());
        } catch (BranchNotFoundException e) {
            branchService.createBranch(branch);
        }
    }

    private void initCar() {
        System.out.println("Starting cars initialization...");

        Car car = new Car();
        car.setModelName("Ford");
        car.setColor("black");
        car.setBodyType("sedan");
        car.setYearOfProd(2023);
        car.setMileage(15000);
        car.setAmount(2);
        car.setBooked(false);

        try {
            Car searchCar = carService.findCarByModelName(car.getModelName());
            System.out.println("Cannot pre-initialize car: " + car.getModelName());
        } catch (CarNotFoundException e) {
            carService.addCar(car);
        }
    }
    private  void initUser(){
        System.out.println("Starting initializing User..");
        try {
            Authority authority = authorityService.findAuthorityByName(AUTHORITY_OWNER);
            User user = new User();
            user.setUsername("admin@study.com");
            user.setPassword("123456");
            user.setAuthority(authority);
            try {
                User resultUser = UserService.findUserByUsername(user.getUsername());
                System.out.println("Cannot pre-initialize user: " + user.getUsername());
            } catch(UserNotFoundException e) {
                UserService.createUser(user);
            }
        } catch (AuthorityNotFoundException e) {
            System.out.println("Cannot pre-initialize User! Reason:  " + e.getLocalizedMessage());
        }

    }

    private  void initBooking(){


    }
    private void initAuthority() {
        System.out.println("Starting initializing Authority..");
        Authority authorityAdmin = new Authority();
        authorityAdmin.setName(AUTHORITY_OWNER);
        createAuthority(authorityAdmin);

        Authority authorityEmployee = new Authority();
        authorityEmployee.setName(AUTHORITY_EMPLOYEE);
        createAuthority(authorityEmployee);

        Authority authorityCustomer = new Authority();
        authorityCustomer.setName(AUTHORITY_CUSTOMER);
        createAuthority(authorityCustomer);
    }

    private void createAuthority(Authority authority) {
        try {
            Authority resultAuthority = authorityService.findAuthorityByName(authority.getName());
            System.out.println("Cannot pre-initialize authority: " + authority.getName());
        } catch (AuthorityNotFoundException e) {
            authorityService.createAuthority(authority);
        }
    }

}
