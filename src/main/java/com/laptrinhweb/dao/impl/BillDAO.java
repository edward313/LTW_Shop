package com.laptrinhweb.dao.impl;

import com.laptrinhweb.dao.IBillDAO;
import com.laptrinhweb.entity.BillEntity;

public class BillDAO extends AbstractDAO<BillEntity> implements IBillDAO {

    @Override
    public Long save(BillEntity billEntity) {
        return insert(billEntity).getId();
    }

}