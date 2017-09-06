package org.proxibanque.dao.impl;

import org.proxibanque.dao.OrdersDao;
import org.proxibanque.model.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrderDaoImpl extends EntityDaoImpl<Order> implements OrdersDao {

}
