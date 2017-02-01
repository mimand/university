/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.service;

import java.util.List;
import university.com.model.Dosen;

/**
 *
 * @author iman
 */
public interface IDosenSrvc {
    public void Save(Dosen dosen);
    public void Update(Dosen dosen);
    public void Delete(Dosen dosen);
    public List<Dosen> getAllDosens();
    public Dosen getSingleDosen(Long id);
    public List<Dosen> getAllDosens(int start,int max);
    public List<Dosen> getSearch(String search);    
}
