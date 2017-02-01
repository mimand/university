/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import university.com.model.Mahasiswa;

/**
 *
 * @author iman
 */
@Repository
public class MahasiswaDaoImpl extends BaseDaoHibernate<Mahasiswa> implements IMahasiswa {

    public List<Mahasiswa> getSearch(String search) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM "
                + domainClass.getName() + " m WHERE lower(m.nama) LIKE lower(:search)")
                .setParameter("search", "%" + search + "%");
        List<Mahasiswa> listSearch = query.list();
        return listSearch;
    }
}
