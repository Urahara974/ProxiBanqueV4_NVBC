/**
 * 
 */
package org.proxibanque.dao.impl;

import org.proxibanque.dao.ConseillersDao;
import org.proxibanque.model.Conseiller;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NVBC
 *
 */

@Component
@Transactional
public class ConseillerDaoImpl extends EntityDaoImpl<Conseiller> implements ConseillersDao {

}
