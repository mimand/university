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
import university.com.dao.IMataKuliah;
import university.com.model.MataKuliah;

/**
 *
 * @author iman
 */
@Service
@Transactional
public class MataKuliahSrvcImpl implements IMataKuliahSrvc {

    @Autowired
    IMataKuliah mataKuliahDao;

    @Override
    public void save(MataKuliah mataKuliah) {
        mataKuliahDao.save(mataKuliah);
    }

    @Override
    public void update(MataKuliah mataKuliah) {
        mataKuliahDao.update(mataKuliah);
    }

    @Override
    public void delete(MataKuliah mataKuliah) {
        mataKuliahDao.delete(mataKuliah);
    }

    @Override
    public List<MataKuliah> getAllMataKuliah() {
        return mataKuliahDao.getAll();
    }

    @Override
    public MataKuliah getSingleMataKuliah(Long id) {
        return mataKuliahDao.getById(id);
    }

    @Override
    public List<MataKuliah> getAllMataKuliahs(int start, int max) {
        return mataKuliahDao.getAll(start, max);
    }

    @Override
    public List<MataKuliah> getSearch(String search) {
        return mataKuliahDao.getSearch(search);
    }

}
