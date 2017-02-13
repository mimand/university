/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.dao;

import java.util.List;

/**
 *
 * @author iman
 */
public interface IBaseDaoHibernate<T> {
    public void save(T domain);
    public void update(T domain);
    public void delete(T domain);
    public List<T> getAll();
    public T getById(Long id);
    public List<T> getAll(Integer start, Integer max);
    public Long count();
}
