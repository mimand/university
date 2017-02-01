/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.service;

import java.util.List;
import university.com.model.MataKuliah;

/**
 *
 * @author iman
 */
public interface IMataKuliahSrvc {
    
    public void save(MataKuliah mataKuliah);
    public void update(MataKuliah mataKuliah);
    public void delete(MataKuliah mataKuliah);
    public List<MataKuliah> getAllMataKuliah();
    public MataKuliah getSingleMataKuliah(Long id);
    public List<MataKuliah> getAllMataKuliahs(int start,int max);
    public List<MataKuliah> getSearch(String search); 
}
