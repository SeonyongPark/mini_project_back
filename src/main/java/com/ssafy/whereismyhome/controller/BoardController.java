package com.ssafy.whereismyhome.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.whereismyhome.model.dto.BoardParameterDTO;
import com.ssafy.whereismyhome.util.PageNavigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.model.dto.BoardDTO;
import com.ssafy.whereismyhome.model.service.BoardService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet implementation class boardController
 */
@RestController
@RequestMapping("/boards")
@CrossOrigin
public class BoardController {
	@Autowired
	private BoardService boardService ;


	@DeleteMapping("/{boardNo}")
	public ResponseEntity<?> delete(@PathVariable("boardNo") String boardNo) {
		Map<String, String> map = new HashMap<String, String>();
		// 서비스 실행
		int cnt = 0;
		try {
			if(boardService.delete(Integer.parseInt(boardNo))) {
				map.put("msg", "success");
				return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
			}

			return new ResponseEntity<Map<String, String>>(map, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			map.put("msg", "삭제 중 오류가 발생했습니다.");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{boardNo}")
	public ResponseEntity<?> update(@PathVariable("boardNo") String boardNo, @RequestBody BoardDTO dto) {
		Map<String, String> map = new HashMap<String, String>();
		// 서비스 실행
		int cnt = 0;
		try {
			dto.setBoardNo(Integer.parseInt(boardNo));
			if(boardService.update(dto)) {
				map.put("msg", "success");
				return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
			}

			return new ResponseEntity<Map<String, String>>(map, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			map.put("msg", "수정 중 오류가 발생하였습니다.");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{boardNo}")
	public ResponseEntity<?> view(@PathVariable("boardNo") String boardNo) {
		Map<String, String> map = new HashMap<String, String>();
		
		int cnt = 0;
		try {
			BoardDTO dto = boardService.view(Integer.parseInt(boardNo));
			
			if(dto == null) {
				map.put("msg", "없는 정보 입니다.");
				return new ResponseEntity<Map<String, String>>(map, HttpStatus.NO_CONTENT);
			}
			map.put("msg", "success");
			return new ResponseEntity<BoardDTO>(dto, HttpStatus.OK);
		} catch (Exception e) {
			map.put("msg", "상세보기 중 에러가 발생하였습니다.");
			e.printStackTrace();
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}

	@PostMapping
	public ResponseEntity<?> write(@RequestBody BoardDTO boardDTO) {
		Map<String, String> map = new HashMap<String, String>();
		
//		if (memberDTO != null) {
			
			try {
//				boardDTO.setUserId(memberDTO.getUserId());
				if(boardService.write(boardDTO)) {
					map.put("data", "success");
					return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
				}
				map.put("data", "fail");
				return new ResponseEntity<Map<String, String>>(map, HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("msg", "글 등록 중 에러가 발생하였습니다.");
				return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
			}
//		}
		
//		return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/{type}/{pg}")
	public ResponseEntity<?> list(@PathVariable("pg") int pg, @PathVariable("type") int type) {
		Map<String, String> map = new HashMap<String, String>();
		BoardParameterDTO boardParameterDto = new BoardParameterDTO();
		boardParameterDto.setPg(pg);
		boardParameterDto.setType(type);

		try {
			List<BoardDTO> list = boardService.list(boardParameterDto);
			return new ResponseEntity<List>(list, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("리스트 에러 : " + e);
			map.put("msg", "글 목록 불러오기 중 에러가 발생하였습니다.");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/nav/{type}/{pg}")
	public ResponseEntity<?> makeNav(@PathVariable("pg") int pg, @PathVariable("type") int type){
		Map<String, Object> check = new HashMap<String, Object>();
		BoardParameterDTO boardParameterDto = new BoardParameterDTO();
		boardParameterDto.setPg(pg);
		boardParameterDto.setType(type);
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		try {
			PageNavigation pageNavigation = boardService.makePageNavigation(boardParameterDto);
			check.put("msg", "success");
			check.put("nav", pageNavigation);

			status = HttpStatus.OK;
		} catch (Exception e){
			e.printStackTrace();
			check.put("msg", "fail");
		}

		return new ResponseEntity<>(check, status);
	}

}
