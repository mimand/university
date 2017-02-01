/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author iman
 */
@Entity
@Table(name = "matakuliah")
public class MataKuliah implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "kode")
    private Long kode;

    @Column(name = "mata_kuliah")
    private String mata_kuliah;

    @Column(name = "sks")
    private int sks;

    @OneToMany(mappedBy = "mataKuliah")
    private List<Nilai> daftarNilai = new ArrayList<>();

    public MataKuliah(Long kode) {
        this.kode = kode;
    }

    public MataKuliah() {
    }

    public List<Nilai> getDaftarNilai() {
        return daftarNilai;
    }

    public void setDaftarNilai(List<Nilai> daftarNilai) {
        this.daftarNilai = daftarNilai;
    }
    
    public String getMata_kuliah() {
        return mata_kuliah;
    }

    public void setMata_kuliah(String mata_kuliah) {
        this.mata_kuliah = mata_kuliah;
    }

    public Long getKode() {
        return kode;
    }

    public void setKode(Long kode) {
        this.kode = kode;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

}
