package com.t3h.module2.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/api/demo")
    public ResponseEntity<String> demo(@RequestParam String name){
        System.out.println(name);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @GetMapping("/api/demo/{age}")
    public ResponseEntity<String> demoAge(@PathVariable Integer age){
        System.out.println(age);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("/api/post/demo")
    public ResponseEntity<String> postDemo(@RequestParam String address, @RequestParam String city){
        System.out.println(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping("/api/post/demo_body")
    public ResponseEntity<String> postDemoBody(
                @RequestParam(defaultValue = "messi") String name,
                @RequestParam(required = false) Integer age,
                @RequestParam String password){
        //
        // decrypted_password = decrypt(getEnvKey('PHUONG_KEY'), password);        //123456
        //123456 + ('qwerttyuuuu') -> aDFA%$#%^TFADSGFFSFAAFASD
        //thanh!2456 + ('qwerttyuuuu') -> adfakf978@$%@%

        System.out.println(name);
        if (name.equalsIgnoreCase("mike")){
            return new ResponseEntity<>("ok", HttpStatus.BAD_REQUEST);
        }
        ////
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
