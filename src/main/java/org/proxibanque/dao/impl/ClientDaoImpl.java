/**
 * 
 */
package org.proxibanque.dao.impl;

import org.proxibanque.dao.ClientsDao;
import org.proxibanque.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class ClientDaoImpl extends EntityDaoImpl<Client> implements ClientsDao {

}
