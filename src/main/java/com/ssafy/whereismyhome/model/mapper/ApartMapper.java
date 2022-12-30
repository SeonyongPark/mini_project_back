package com.ssafy.whereismyhome.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.ssafy.whereismyhome.model.dto.*;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ApartMapper {
	void addApart(ApartDTO apartDTO) throws Exception;
	void deleteApart(String user_id, String aprCode) throws Exception;
	ArrayList<HouseDTO> searchDeal(Map<String, String> map) throws Exception;
	ArrayList<Data> getSido(Data data) throws SQLException;
	ArrayList<Data> getGugun(Data data) throws SQLException;
	ArrayList<Data> getDong(Data data) throws SQLException;
	ArrayList<DateDTO> searchDate(String code) throws SQLException;
	void addInterest(InterestDTO dto) throws SQLException;
	void deleteInterest(InterestDTO dto) throws SQLException;
	ArrayList<MypageDTO> mypageList(String id) throws SQLException;
	AggregateDTO avg(String code) throws SQLException;
	ArrayList<DateDTO> history(String code) throws SQLException;

}
