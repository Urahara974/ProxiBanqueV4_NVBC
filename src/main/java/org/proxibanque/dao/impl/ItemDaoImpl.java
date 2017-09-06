package org.proxibanque.dao.impl;


import org.proxibanque.dao.ItemsDao;
import org.proxibanque.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class ItemDaoImpl extends EntityDaoImpl<Item> implements ItemsDao {

	
}

