package com.mac.macstore.di;
import com.mac.macstore.bll.abstractions.repositories.IDeviceRepository;
import com.mac.macstore.bll.abstractions.services.IDeviceService;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.javalang.injection")
public class Config {
    public IDeviceRepository deviceRepository;
    public IDeviceService deviceService;
}
