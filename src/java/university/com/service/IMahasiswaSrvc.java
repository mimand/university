/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.service;

import java.util.List;
import university.com.model.Mahasiswa;

/**
 *
 * @author iman
 */
public interface IMahasiswaSrvc {
    
    public void Save(Mahasiswa mahasiswa);
    public void Update(Mahasiswa mahasiswa);
    public void Delete(Mahasiswa mahasiswa);
    public List<Mahasiswa> getAllMahasiswas();
    public Mahasiswa getSingleMahasiswa(Long id);
    public List<Mahasiswa> getAllMahasiswas(Integer start, Integer max);
    public List<Mahasiswa> getSearch(String search);
    public Long count();


    
}
