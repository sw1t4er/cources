package com.nbu.demo.controller;

import com.nbu.demo.model.Address;
import com.nbu.demo.model.User;
import com.nbu.demo.pojo.AddressDetail;
import com.nbu.demo.service.AddressService;
import com.nbu.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value="/api/user/address", produces = "application/json")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    UserService useerService;


    User user;
    Address address;

    @PostMapping
    public HttpStatus setAddress(@Valid @RequestBody AddressDetail addressDetail) {
        user = useerService.findById(addressDetail.getId()).orElseThrow(NoSuchFieldError::new);
        address=new Address();
        address.setAddress(addressDetail.getAddress());
        address.setZip(addressDetail.getZip());
        address.setAddressUserId(user);
        addressService.save(address);
        return HttpStatus.CREATED;
    }
}
