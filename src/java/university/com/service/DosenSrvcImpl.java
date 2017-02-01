/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import university.com.dao.IDosen;
import university.com.model.Dosen;

/**
 *
 * @author iman
 */
@Service
@Transactional
public class DosenSrvcImpl implements IDosenSrvc{
    @Autowired
    IDosen dosenDao;

    @Override
    public void Save(Dosen dosen) {
        dosenDao.save(dosen);
    }

    @Override
    public void Update(Dosen dosen) {
        dosenDao.update(dosen);
    }

    @Override
    public void Delete(Dosen dosen) {
        dosenDao.delete(dosen);
    }

    @Override
    public List<Dosen> getAllDosens() {
        return dosenDao.getAll();
    }

    @Override
    public Dosen getSingleDosen(Long id) {
        return dosenDao.getById(id);
    }

    @Override
    public List<Dosen> getAllDosens(int start, int max) {
        return dosenDao.getAll(start, max);
    }

    @Override
    public List<Dosen> getSearch(String search) {
        return dosenDao.getSearch(search);
    }
    
}
