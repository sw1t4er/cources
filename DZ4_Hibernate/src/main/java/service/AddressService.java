package service;

import dao.AddressDao;
import model.Address;

import java.util.List;

public class AddressService {
    AddressDao addressDao = new AddressDao();

    public Address findById(Long id) {
        return addressDao.findById(id);
    }

    public void save(Address address) {
        addressDao.save(address);
    }

    public void update(Address address) {
        addressDao.update(address);
    }

    public void delete(Address address) {
        addressDao.delete(address);
    }

    public List<Address> findAll() {
        return addressDao.findAll();
    }
}