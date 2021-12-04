package com.laptrinhweb.dao;

import com.laptrinhweb.entity.BillEntity;

public interface IBillDAO {
    Long save(BillEntity billEntity);
}