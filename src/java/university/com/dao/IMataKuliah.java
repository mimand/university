/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.dao;

import java.util.List;
import university.com.model.MataKuliah;

/**
 *
 * @author iman
 */
public interface IMataKuliah extends IBaseDaoHibernate<MataKuliah>{
        public List<MataKuliah> getSearch(String search);

}
