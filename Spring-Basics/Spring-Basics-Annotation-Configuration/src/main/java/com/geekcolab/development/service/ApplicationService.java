package com.geekcolab.development.service;

import org.springframework.stereotype.Service;

@Service("applicationService")
public class ApplicationService {
    public void sayHello(){
        System.out.println("Hello from " + this.getClass().getSimpleName());
    }
}
