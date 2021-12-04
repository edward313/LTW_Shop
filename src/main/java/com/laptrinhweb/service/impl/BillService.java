package com.laptrinhweb.service.impl;

import javax.inject.Inject;

import com.laptrinhweb.dao.IBillDAO;
import com.laptrinhweb.entity.BillEntity;
import com.laptrinhweb.service.IBillService;

public class BillService implements IBillService{
    @Inject
    private IBillDAO billDAO;
    @Override
    public Long save(BillEntity billEntity) {
        return billDAO.save(billEntity);
    }

}