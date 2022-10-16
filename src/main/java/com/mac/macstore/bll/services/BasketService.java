package com.mac.macstore.bll.services;

import com.mac.macstore.bll.abstractions.repositories.IBasketRepository;
import com.mac.macstore.bll.abstractions.repositories.IProductRepository;
import com.mac.macstore.bll.abstractions.services.IBasketService;
import com.mac.macstore.bll.abstractions.services.IProductService;
import com.mac.macstore.bll.models.BasketEntity;
import com.mac.macstore.bll.models.ProductEntity;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class BasketService implements IBasketService {
    private IBasketRepository basketRepository;

    public BasketService(IBasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void create(BasketEntity entity) throws SQLException {
        basketRepository.create(entity);
    }
    public void update(BasketEntity entity) throws SQLException {
        basketRepository.update(entity);
    }
    public void delete(int id) throws SQLException {
        basketRepository.delete(id);
    }
    public ArrayList<BasketEntity> getAll(int id) throws SQLException {
        return basketRepository.getAll(id);
    }
}

