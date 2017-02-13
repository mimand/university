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
import university.com.model.Mahasiswa;
import university.com.dao.IMahasiswa;

/**
 *
 * @author iman
 */
@Service
@Transactional
public class MahasiswaSrvcImpl implements IMahasiswaSrvc{
    
    @Autowired
    IMahasiswa mahasiswaDAO;

    @Override
    public void Save(Mahasiswa mahasiswa) {
        mahasiswaDAO.save(mahasiswa);
    }

    @Override
    public void Update(Mahasiswa mahasiswa) {
        mahasiswaDAO.update(mahasiswa);
    }

    @Override
    public void Delete(Mahasiswa mahasiswa) {
        mahasiswaDAO.delete(mahasiswa);
    }

    @Override
    public List<Mahasiswa> getAllMahasiswas() {
        return mahasiswaDAO.getAll();
    }

    @Override
    public Mahasiswa getSingleMahasiswa(Long id) {
        return (Mahasiswa) mahasiswaDAO.getById(id);
    }

    @Override
    public List<Mahasiswa> getAllMahasiswas(Integer start, Integer max) {
        return mahasiswaDAO.getAll(start, max);
    }

    @Override
    public List<Mahasiswa> getSearch(String search) {
        return mahasiswaDAO.getSearch(search);
    }

    @Override
    public Long count() {
        return mahasiswaDAO.count();
    }
}
