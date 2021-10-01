package com.geekcolab.development.springhelloworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApplicationService {

    @GetMapping("")
    public ResponseEntity<?> getMap() {
        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }

}
