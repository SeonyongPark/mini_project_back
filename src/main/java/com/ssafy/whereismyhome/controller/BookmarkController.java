package com.ssafy.whereismyhome.controller;

import com.ssafy.whereismyhome.model.dto.BookmarkDTO;
import com.ssafy.whereismyhome.model.dto.HouseinfoDTO;
import com.ssafy.whereismyhome.model.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    @PostMapping
    ResponseEntity<?> regist(@RequestBody BookmarkDTO dto){
        Map<String, Object> check = new HashMap<>();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        try{
            if(bookmarkService.like(dto)){
                status = HttpStatus.OK;
                check.put("msg", "success");
            } else{
                check.put("msg", "success");
            }

        } catch (Exception e){
            e.printStackTrace();
            check.put("msg", "fail");
        }

        return new ResponseEntity<>(check, status);
    }

    @DeleteMapping("/{code}")
    ResponseEntity<?> delete(@PathVariable String code){
        Map<String, Object> check = new HashMap<>();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        try{
            if(bookmarkService.delete(code)){
                status = HttpStatus.OK;
                check.put("msg", "success");
            } else{
                check.put("msg", "success");
            }
        } catch (Exception e){
            e.printStackTrace();
            check.put("msg", "fail");
        }

        return new ResponseEntity<>(check, status);
    }

    @GetMapping("/{userId}")
    ResponseEntity<?> list(@PathVariable("userId") String userId){
        Map<String, Object> check = new HashMap<>();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        try{
            List<HouseinfoDTO> list = bookmarkService.list(userId);
            if(list == null){
                status = HttpStatus.NO_CONTENT;
                check.put("msg", "fail");
            }else {
                status = HttpStatus.OK;
                check.put("msg", "success");
                check.put("list", list);
            }

        } catch (Exception e){
            e.printStackTrace();
            check.put("msg", "fail");
        }

        return new ResponseEntity<>(check, status);
    }

    @GetMapping("/{userId}/{code}")
    ResponseEntity<?> comfirm(@PathVariable("userId") String userId, @PathVariable("code") String code){
        Map<String, Object> check = new HashMap<>();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("code", code);


        try{
            if(bookmarkService.comfirm(map)){
                status = HttpStatus.OK;
                check.put("msg", "success");
                check.put("check", true);
            }else {
                status = HttpStatus.OK;
                check.put("msg", "fail");
                check.put("check", false);
            }

        } catch (Exception e){
            e.printStackTrace();
            check.put("msg", "fail");
        }

        return new ResponseEntity<>(check, status);
    }


}
