package com.ssafy.whereismyhome.controller;

import com.ssafy.whereismyhome.model.dto.AggregateDTO;
import com.ssafy.whereismyhome.model.dto.Data;
import com.ssafy.whereismyhome.model.dto.DateDTO;
import com.ssafy.whereismyhome.model.dto.HouseDTO;
import com.ssafy.whereismyhome.model.service.ApartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/aparts")
public class ApartController  {
	
	@Autowired
	ApartService service;
	
//	@PostMapping("/delteplace")
//	private ResponseEntity<?> deletePlace(HttpServletRequest request, HttpServletResponse response) {
//		String code = request.getParameter("code")+"000000";
//		HttpSession session = request.getSession();
//		MemberDTO dto = (MemberDTO) session.getAttribute("userInfo");
//		String id = dto.getUserId();
//		InterestDTO interDto = new InterestDTO();
//		interDto.setDongCode(code);
//		interDto.setUser_id(id);
//		Map<String, Object> map = new HashMap<>();
//
//		try {
//			service.deleteInterest(interDto);
//			map.put("msg", "관심 지역 등록 성공!");
//			System.out.println("관심 지역 삭제 성공!");
//			return new ResponseEntity(map,HttpStatus.CREATED);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("관심 지역 삭제 중 에러 발생!");
//			map.put("msg", "관심 지역 등록 중 에러 발생!");
//			return new ResponseEntity(map,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	
//	}
	
//	@PostMapping("/addplace")
//	private ResponseEntity<?> addPlace(HttpServletRequest request, HttpServletResponse response) {
//		String code = request.getParameter("code")+"000000";
//		HttpSession session = request.getSession();
//		MemberDTO dto = (MemberDTO) session.getAttribute("userInfo");
//		String id = dto.getUserId();
//		String ip_address = request.getRemoteAddr();
//		
//		InterestDTO interDto = new InterestDTO();
//		interDto.setDongCode(code);
//		interDto.setUser_id(id);
//		interDto.setIp_address(ip_address);
//		Map<String, Object> map = new HashMap<>();
//		try {
//			service.addInterest(interDto);
//			map.put("msg", "관심 지역 등록 성공!");
//			System.out.println("관심 지역 등록 성공!");
//			return new ResponseEntity(map,HttpStatus.CREATED);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("관심 지역 등록 중 에러 발생!");
//			map.put("msg", "관심 지역 등록 중 에러 발생!");
//			return new ResponseEntity(map,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

//	private String date(HttpServletRequest request, HttpServletResponse response) {
//		String code = request.getParameter("code");
//		
//		try {
//			return service.searchDate(code);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	
	@GetMapping("/{code}/{year}/{month}")
	public ResponseEntity<?> search(@PathVariable String code, @PathVariable String year, @PathVariable String month) {
		Map<String, String> map = new HashMap<>();

		map.put("code", code);
		map.put("year", year);
		map.put("month", month);

		try {
			ArrayList<HouseDTO> list = service.searchDeal(map);
			System.out.println(list);
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/codes")
	public ResponseEntity<?> doSido() {
		try {
			ArrayList<Data> list = service.getSido(null);
			if(list==null) {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/codes/{sidoCode}")
	public ResponseEntity<?> doGugun(@PathVariable("sidoCode") String code) {
		try {
			Data data = new Data();
			data.setCode(code);
			ArrayList<Data> list = service.getGugun(data);
			if(list==null) {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
	@GetMapping("/codes/{sidoCode}/{gugunCode}")
	public ResponseEntity<?> doDong(@PathVariable("gugunCode") String gugunCode,@PathVariable("sidoCode") String sidoCode) {
		
		try {
			Data data = new Data();
			data.setCode(sidoCode.concat(gugunCode));
			ArrayList<Data> list = service.getDong(data);
			if(list==null) {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	@GetMapping("/average/{code}")
	public ResponseEntity<?> avg(@PathVariable String code){
		Map<String, Object> check = new HashMap<>();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		try{
			AggregateDTO dto = service.avg(code);
			if(dto == null){
				status = HttpStatus.NO_CONTENT;
				check.put("msg", "fail");
			}
			else {
				status = HttpStatus.OK;
				check.put("msg", "success");
				check.put("list", dto);
			}
		} catch (Exception e){
			e.printStackTrace();
			check.put("msg", "fail");
		}

		return new ResponseEntity<>(check, status);
	}

	@GetMapping("/history/{code}")
	public ResponseEntity<?> history(@PathVariable String code){
		Map<String, Object> check = new HashMap<>();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		System.out.println(code);

		try{
			List<DateDTO> list = service.history(code);
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
	
//	private void cancel(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		MemberDTO dto = (MemberDTO)session.getAttribute("userInfo");
//		
//		String user_id = dto.getUserId();
//		String no = request.getParameter("no");
//		
//
//		ApartDTO apartDTO = null;
//		try {
//			service.deleteApart(user_id, no);
//			request.setAttribute("msg", "관심 정보 삭제 성공!");
//			System.out.println("관심 정보 삭제 성공!");
//		} catch (Exception e) {
//			System.out.println("관심 정보 등록 중 에러 발생!");
//			request.setAttribute("msg", "관심 정보 삭제 중 에러 발생!");
//		}
//	}

//	private void add(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		
//		MemberDTO dto = (MemberDTO)session.getAttribute("userInfo");
//		String no = request.getParameter("no");
//		String ip_address = request.getRemoteAddr();
//		
//		System.out.println(dto.getUserId());
//		ApartDTO apartDTO = new ApartDTO();
//		if(dto.getUserId() != null) {
//			apartDTO.setUser_id(dto.getUserId());
//			apartDTO.setNo(no);
//			apartDTO.setIp_address(ip_address);
//		} else {
//			System.out.println("관심 정보 등록 중 에러 발생!");
//			request.setAttribute("msg", "관심 정보 등록 중 에러 발생!");
//			return;
//		}
//		try {
//			service.addApart(apartDTO);
//			request.setAttribute("msg", "관심 정보 등록 성공!");
//			System.out.println("관심 정보 등록 성공!");
//		} catch (Exception e) {
//			System.out.println("관심 정보 등록 중 에러 발생!");
//			request.setAttribute("msg", "관심 정보 등록 중 에러 발생!");
//		}
//
//	}

}
