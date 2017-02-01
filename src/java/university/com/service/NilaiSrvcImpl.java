/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.com.dao.INilai;
import university.com.model.Nilai;

/**
 *
 * @author iman
 */
@Service
@Transactional
public class NilaiSrvcImpl implements INilaiSrvc{
    
    @Autowired
    INilai nilaiDao;
    
    @Override
    public void save(Nilai nilai) {
        nilaiDao.save(nilai);
    }

    @Override
    public void update(Nilai nilai) {
        nilaiDao.update(nilai);
    }

    @Override
    public void delete(Nilai nilai) {
        nilaiDao.delete(nilai);
    }

    @Override
    public List<Nilai> getAllNilai() {
        return nilaiDao.getAll();
    }

    @Override
    public Nilai getSingleNilai(Long id) {
        return nilaiDao.getById(id);
    }

    @Override
    public List<Nilai> getAllNilais(int start, int max) {
        return nilaiDao.getAll(start, max);
    }
    
}
