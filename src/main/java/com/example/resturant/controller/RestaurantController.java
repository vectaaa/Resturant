package com.example.resturant.controller;

import com.example.resturant.config.PasswordHashing;
import com.example.resturant.dto.LoginDto;
import com.example.resturant.dto.RestaurantDto;
import com.example.resturant.entity.Restaurant;
import com.example.resturant.exceptions.RestaurantException;
import com.example.resturant.repository.RestaurantRepository;
import com.example.resturant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/restaurants")
public class RestaurantController {

    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private PasswordHashing passwordHashing;

//    @PostMapping//Here we handle the signup API
    @PostMapping("/signup")
    public ResponseEntity<?> signUp( @RequestBody RestaurantDto restaurantDto) {

        System.out.println( " printing class " + restaurantDto);
//        Restaurant restaurant = new Restaurant();

        Optional<Restaurant> foundByEmail = restaurantRepo.findByEmail(restaurantDto.getEmail());
        if (foundByEmail.isPresent()) {
            throw new RestaurantException("User already exists with the email " + restaurantDto.getEmail());
        } else {
            Restaurant restaurant = new Restaurant();
            restaurant.setOwnersName(restaurantDto.getOwnersName());
            restaurant.setEmail(restaurantDto.getEmail());
            restaurant.setRestaurantAddress(restaurantDto.getRestaurantAddress());
            restaurant.setRestaurantName(restaurantDto.getRestaurantName());
            restaurant.setCacFileName(restaurantDto.getCacFileName());
            restaurant.setPhoneNumber(restaurantDto.getPhoneNumber());

            //Where we used the Hashing of the password from the config package
            restaurant.setPassword(passwordHashing.encryptPassword(restaurantDto.getPassword()));
            restaurantRepo.save(restaurant);

//            try {
//                HttpHeaders headers = new HttpHeaders();
//
//                String cacFileName = file.getOriginalFilename();
//                String cacFilePath = Paths.get(uploadDirectory, cacFileName).toString();
//                String fileType = file.getContentType();
//                long size = file.getSize();
//                String fileSize = String.valueOf(size);
//
//
//                //Save the file locally
//                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(cacFilePath)));
//                stream.write(file.getBytes());
//                stream.close();
//
//                restaurant.setCacFileName(restaurantDto.getCacFileName());
//                restaurant.setCacFileType(restaurantDto.getCacFileType());
//                restaurant.setCacFileSize(restaurantDto.getCacFileSize());

//            Restaurant saved = restaurantService.signUp(restaurantDto);

//            if (saved != null) {
//                System.out.println("Restaurant created successfully");
//
////                    headers.add("Restaurant saved with file - ", cacFileName);
//
////                    return new ResponseEntity<>("Restaurant created with File - " + cacFileName, headers, HttpStatus.OK);
//            }
            return new ResponseEntity<>("Registration Completed", HttpStatus.CREATED);

//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }



//    public ResponseEntity<?> sendLogin(@RequestBody RestaurantDtoy restaurantDto) {
//        Restaurant restaurant = restaurantService.
//    }


    @PostMapping("/login/sendLogin")
    public ResponseEntity<Restaurant> login (@RequestBody LoginDto loginDto){
        System.out.println("I got in the login controller "+loginDto);


        return ResponseEntity.ok(restaurantService.login(loginDto));
    }
}
