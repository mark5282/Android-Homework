package com.example.hotel.dao;

import com.example.hotel.baen.Provincebean;
import java.util.List;

public interface ProvincebeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provincebean record);

    Provincebean selectByPrimaryKey(Integer id);

    List<Provincebean> selectAll();

    int updateByPrimaryKey(Provincebean record);
}