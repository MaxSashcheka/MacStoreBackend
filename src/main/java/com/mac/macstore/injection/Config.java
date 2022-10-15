package com.mac.macstore.injection;
import com.mac.macstore.bll.abstractions.repositories.IProductRepository;
import com.mac.macstore.bll.abstractions.repositories.IProductTypeRepository;
import com.mac.macstore.bll.abstractions.services.IProductService;
import com.mac.macstore.bll.abstractions.services.IProductTypeService;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.javalang.injection")
public class Config {
    public IProductRepository deviceRepository;
    public IProductService deviceService;
    public IProductTypeRepository productTypeRepository;
    public IProductTypeService productTypeService;
}
