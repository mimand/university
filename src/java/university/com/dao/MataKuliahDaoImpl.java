/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import university.com.model.Matakuliah;

/**
 *
 * @author iman
 */
@Repository
public class MataKuliahDaoImpl extends BaseDaoHibernate<Matakuliah>
        implements IMataKuliah {

    public List<Matakuliah> getSearch(String search) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM "
                + domainClass.getName() + " m WHERE lower(m.mata_kuliah) LIKE lower(:search)")
                .setParameter("search", "%" + search + "%");
        List<Matakuliah> listSearch = query.list();
        return listSearch;
    }
}
