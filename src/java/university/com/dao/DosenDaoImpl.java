/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import university.com.model.Dosen;

/**
 *
 * @author iman
 */
@Repository
public class DosenDaoImpl extends BaseDaoHibernate<Dosen> implements IDosen{
    
        public List<Dosen> getSearch(String search){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM "
                + domainClass.getName() + " m WHERE lower(dosen) LIKE lower(:search)")
                .setParameter("search", "%" + search + "%");
        List<Dosen> listSearch= query.list();
        return listSearch;
    }
}
