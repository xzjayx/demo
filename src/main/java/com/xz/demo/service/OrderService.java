package com.xz.demo.service;

import com.xz.demo.config.general.SequenceId;
import com.xz.demo.dao.OrderMapper;
import com.xz.demo.model.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderDao;
    @Autowired
    private SequenceId sequenceId;

    public Order save(Order order){
         order.setId(sequenceId.nextId());
         orderDao.insert(order);
         return order;
    }

}
