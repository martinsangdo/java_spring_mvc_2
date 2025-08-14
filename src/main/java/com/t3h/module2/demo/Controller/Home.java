package com.t3h.module2.demo.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@RestController
public class Home {
    private static final String STATIC_DIR = "src/main/resources/static/";

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
    //3.2
    @GetMapping("/demo/hello")
    public ResponseEntity<String> displayHelloMe(@RequestParam String name){
        String aString = "Hello " + name;
        return new ResponseEntity<>(aString, HttpStatus.OK);
    }
    //3.3
    @GetMapping(value = "/demo/page2", produces = MediaType.TEXT_HTML_VALUE)
    public String display3_3() {
        Context context = new Context();
        return templateEngine.process("unit_javascript", context);
    }
    //7.1
    @PostMapping(value = "/api/images")
    public ResponseEntity<String> uploadImages(@RequestParam("files") List<MultipartFile> files) {
        // Validate
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("One of the files is empty: " + file.getOriginalFilename());
            }
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return new ResponseEntity<>("One of file is invalid, filename: " + file.getOriginalFilename(), HttpStatus.BAD_REQUEST);
            }
        }

        // Save files
        try {
            for (MultipartFile file : files) {
                Path targetPath = Paths.get(STATIC_DIR + file.getOriginalFilename())
                        .normalize().toAbsolutePath();
                Files.createDirectories(targetPath.getParent());
                file.transferTo(targetPath.toFile());
            }
        } catch (IOException e) {
            return new ResponseEntity<>("Files cannot be uploaded", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Files are received successfully", HttpStatus.OK);
    }
}

