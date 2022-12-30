package com.ssafy.whereismyhome.controller;

import com.ssafy.whereismyhome.model.dto.CommentDTO;
import com.ssafy.whereismyhome.model.dto.CommentParameterDto;
import com.ssafy.whereismyhome.model.service.CommentService;
import com.ssafy.whereismyhome.util.PageNavigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("boards/{boardNo}/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/{pg}")
    public ResponseEntity<?> list(@PathVariable("pg") int pg,
        @PathVariable("boardNo") int boardNo){
        System.out.println(pg+"***********************************");
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        CommentParameterDto commentParameterDto = new CommentParameterDto();
        Map<String, Object> check = new HashMap<>();
        commentParameterDto.setBoard_no(boardNo);
        commentParameterDto.setPg(pg);


        try{
            List<CommentDTO> commentDTOList = commentService.list(commentParameterDto);
            if(commentDTOList != null){
                check.put("list", commentDTOList);
                check.put("msg", "success");
                status = HttpStatus.OK;
            } else{
                check.put("msg", "No Content");
                status = HttpStatus.NO_CONTENT;
            }

        } catch(Exception e){
            e.printStackTrace();
            check.put("msg", "fail");
        }

        return new ResponseEntity<>(check, status);
    }

    @PostMapping()
    public ResponseEntity<?> regist(@RequestBody CommentDTO commentDTO){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> check = new HashMap<>();

        try {
            if(commentService.write(commentDTO)){
                check.put("msg", "success");
                status = HttpStatus.OK;
            }
        }catch (Exception e){
            e.printStackTrace();
            check.put("msg", "fail");
        }

        return new ResponseEntity<Map>(check, status);
    }

    // "boards/{boardNo}/comments"
    @PutMapping("/{comment_id}")
    public ResponseEntity<?> update(@RequestBody CommentDTO commentDTO){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> check = new HashMap<>();

        try {
            if(commentService.update(commentDTO)){
                check.put("msg", "success");
                status = HttpStatus.OK;
            } else{
                check.put("msg", "fail");
            }
        }catch (Exception e){
            e.printStackTrace();
            check.put("msg", "fail");
        }

        return new ResponseEntity<Map>(check, status);
    }

    @DeleteMapping("/{comment_id}")
    public ResponseEntity<?> delete(@PathVariable int comment_id){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> check = new HashMap<>();

        try {
            if(commentService.delete(comment_id)){
                check.put("msg", "success");
                status = HttpStatus.OK;
            } else{
                check.put("msg", "fail");
            }
        }catch (Exception e){
            e.printStackTrace();
            check.put("msg", "fail");
        }

        return new ResponseEntity<Map>(check, status);
    }

    @GetMapping("/nav/{pg}")
    public ResponseEntity<?> makeNav(@PathVariable("boardNo") int boardNo, @PathVariable("pg") int pg){
        Map<String, Object> check = new HashMap<String, Object>();
        CommentParameterDto commentParameterDto = new CommentParameterDto();
        commentParameterDto.setPg(pg);
        commentParameterDto.setBoard_no(boardNo);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            PageNavigation pageNavigation = commentService.makePageNavigation(commentParameterDto);
            check.put("msg", "success");
            check.put("tag", pageNavigation);
            status = HttpStatus.OK;
        } catch (Exception e){
            e.printStackTrace();
            check.put("msg", "fail");
        }

        return new ResponseEntity<>(check, status);
    }

}
