/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import university.com.model.MataKuliah;

/**
 *
 * @author iman
 */
@Repository
public class MataKuliahDaoImpl extends BaseDaoHibernate<MataKuliah>
        implements IMataKuliah {

    public List<MataKuliah> getSearch(String search) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM "
                + domainClass.getName() + " m WHERE lower(m.mata_kuliah) LIKE lower(:search)")
                .setParameter("search", "%" + search + "%");
        List<MataKuliah> listSearch = query.list();
        return listSearch;
    }
}
