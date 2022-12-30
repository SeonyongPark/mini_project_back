package com.ssafy.whereismyhome.model.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.ssafy.whereismyhome.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ssafy.whereismyhome.model.mapper.ApartMapper;


@Service
public class ApratServiceImpl implements ApartService {
	
	@Autowired
	private ApartMapper apartMapper ;



	public void addApart(ApartDTO apartDTO) throws Exception {
		apartMapper.addApart(apartDTO);
	}
	@Override
	public void deleteApart(String user_id, String aptCode) throws Exception {
		apartMapper.deleteApart(user_id, aptCode);
	}
	@Override
	public ArrayList<Data> getSido(Data data) throws Exception {
		ArrayList<Data> list =apartMapper.getSido(data); 
		return list;
	}

	@Override
	public ArrayList<Data> getGugun(Data data) throws Exception {

		return apartMapper.getGugun(data);
	}

	@Override
	public ArrayList<Data> getDong(Data data) throws Exception {

		return apartMapper.getDong(data);
	}
	@Override
	public ArrayList<HouseDTO> searchDeal(Map<String, String> map) throws Exception {
		String str = map.get("code").substring(0, 8)+"%";
		map.put("code", str);
		return apartMapper.searchDeal(map);
	}
	@Override
	public String searchDate(String code) throws SQLException {
		Gson gson = new Gson();
		String json = gson.toJson(apartMapper.searchDate(code)); 
		return json;
	}
	@Override
	public void addInterest(InterestDTO dto) throws SQLException {
		apartMapper.addInterest(dto);
	}
	@Override
	public void deleteInterest(InterestDTO dto) throws SQLException {
		apartMapper.deleteInterest(dto);
	}
	@Override
	public String mypageList(String id) throws Exception {
		Gson gson = new Gson();
		String json = gson.toJson(apartMapper.mypageList(id)); 
		return json;
	}

	@Override
	public AggregateDTO avg(String code) throws Exception {
		return apartMapper.avg(code);
	}

	@Override
	public ArrayList<DateDTO> history(String code) throws SQLException {
		return apartMapper.history(code);
	}

}
