package com.example.controller;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age , MultipartFile image){
        log.info("username:{},age:{},image:()",username,age,image);

        // uuid
        String uuid = UUID.randomUUID().toString();


        return Result.success();
    }
}
