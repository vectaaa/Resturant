package com.example.resturant.services;

import com.example.resturant.entity.Attach;
import org.springframework.web.multipart.MultipartFile;

public interface AttachService {

        Attach upload(MultipartFile file) throws Exception;

        Attach getImage(String attachName) throws Exception;



}
