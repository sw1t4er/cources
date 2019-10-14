package service;

import dao.GoodDao;
import dao.GoodDao;
import model.Good;

import java.util.List;

public class GoodService {
    GoodDao goodDao = new GoodDao();

    public Good findById(Long id) {
        return goodDao.findById(id);
    }

    public void save(Good good) {
        goodDao.save(good);
    }

    public void update(Good good) {
        goodDao.update(good);
    }

    public void delete(Good good) {
        goodDao.delete(good);
    }

    public List<Good> findAll() {
        return goodDao.findAll();
    }
}