/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.service;

import java.util.List;
import university.com.model.Nilai;

/**
 *
 * @author iman
 */
public interface INilaiSrvc {
 
    public void save(Nilai nilai);
    public void update(Nilai nilai);
    public void delete(Nilai nilai);
    public List<Nilai> getAllNilai();
    public Nilai getSingleNilai(Long id);
    public List<Nilai> getAllNilais(Integer start, Integer max);   
}
