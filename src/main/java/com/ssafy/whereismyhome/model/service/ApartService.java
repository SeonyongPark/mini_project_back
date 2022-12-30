package com.ssafy.whereismyhome.model.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.ssafy.whereismyhome.model.dto.*;


public interface ApartService {
	void addApart(ApartDTO apartDTO) throws Exception;
	void deleteApart(String user_id, String aprCode) throws Exception;
	ArrayList<HouseDTO> searchDeal(Map<String, String> map) throws Exception;
	ArrayList<Data> getSido(Data data) throws Exception;
	ArrayList<Data> getGugun(Data data) throws Exception;
	ArrayList<Data> getDong(Data data) throws Exception;
	String searchDate(String code) throws SQLException;
	void addInterest(InterestDTO dto) throws SQLException;
	void deleteInterest(InterestDTO dto) throws SQLException;
	String mypageList(String id) throws Exception;
	AggregateDTO avg(String code) throws Exception;

	ArrayList<DateDTO> history(String code) throws SQLException;
}
