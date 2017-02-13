/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.service;

import java.util.List;
import university.com.model.Matakuliah;

/**
 *
 * @author iman
 */
public interface IMataKuliahSrvc {
    
    public void save(Matakuliah mataKuliah);
    public void update(Matakuliah mataKuliah);
    public void delete(Matakuliah mataKuliah);
    public List<Matakuliah> getAllMataKuliah();
    public Matakuliah getSingleMataKuliah(Long id);
    public List<Matakuliah> getAllMataKuliahs(Integer start, Integer max);
    public List<Matakuliah> getSearch(String search); 
}
