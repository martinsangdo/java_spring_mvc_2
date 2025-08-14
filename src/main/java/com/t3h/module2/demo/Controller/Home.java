package com.t3h.module2.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@RestController
public class Home {

    @Autowired
    private SpringTemplateEngine templateEngine; // Inject Thymeleaf's template engine
    
    @GetMapping(value = "/unit1_1", produces = MediaType.TEXT_HTML_VALUE)
    public String pageUnit1_1() {
        Context context = new Context();
        return templateEngine.process("unit1_1", context);
    }

    @GetMapping(value = "/unit1_2", produces = MediaType.TEXT_HTML_VALUE)
    public String pageUnit1_2() {
        Context context = new Context();
        return templateEngine.process("unit1_2", context);
    }

    @GetMapping(value = "/unit1_3", produces = MediaType.TEXT_HTML_VALUE)
    public String pageUnit1_3() {
        Context context = new Context();
        return templateEngine.process("unit1_3", context);
    }

    @GetMapping(value = "/unit1_4", produces = MediaType.TEXT_HTML_VALUE)
    public String pageUnit1_4() {
        Context context = new Context();
        return templateEngine.process("unit1_4", context);
    }

    @GetMapping(value = "/unit_css", produces = MediaType.TEXT_HTML_VALUE)
    public String pageUnitCSS() {
        Context context = new Context();
        return templateEngine.process("unit_css", context);
    }

    @GetMapping(value = "/unit_javascript", produces = MediaType.TEXT_HTML_VALUE)
    public String pageUnitJavascript() {
        Context context = new Context();
        return templateEngine.process("unit_javascript", context);
    }

    @GetMapping("/demo/hello")
    public ResponseEntity<String> displayHelloMe(@RequestParam String name){
        String aString = "Hello " + name;
        return new ResponseEntity<>(aString, HttpStatus.OK);
    }

    @GetMapping(value = "/demo/page2", produces = MediaType.TEXT_HTML_VALUE)
    public String display3_3() {
        Context context = new Context();
        return templateEngine.process("unit_javascript", context);
    }
}

