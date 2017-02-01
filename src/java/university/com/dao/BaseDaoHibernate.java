/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author iman
 */
public class BaseDaoHibernate<T>{
    
    @SuppressWarnings("unchecked")
    protected Class domainClass;
    
    @Autowired
    protected SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
    public BaseDaoHibernate(){
      this.domainClass =(Class) ((ParameterizedType)
                getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
    public void save(T domain){
        sessionFactory.getCurrentSession().saveOrUpdate(domain);
    }
    public void delete(T domain){
        sessionFactory.getCurrentSession().delete(domain);
    }
    public void update(T domain ) {
        sessionFactory.getCurrentSession().update(domain);
    }    
    @SuppressWarnings("unchecked")
    public T getById(Long id){
        return (T) sessionFactory.getCurrentSession().get(domainClass, id);
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll(){
        return sessionFactory.getCurrentSession().createQuery("FROM "+
                domainClass.getName()).list();
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll(int start,int max){
        return sessionFactory.getCurrentSession().createQuery("FROM "+
                domainClass.getName()).setFirstResult(start).setMaxResults(max).list();
    }
}
