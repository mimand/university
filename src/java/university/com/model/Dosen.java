/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author iman
 */
@Entity
@Table(name = "dosen")
public class Dosen implements Serializable {
    public enum GenderType {
        Pria,Perempuan;
    }
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "nip")
    private Long nip;

    @Column(name = "nm_dosen")
    private String dosen;

    @Column(name = "alamat")
    private String alamat;
    
    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;

    @OneToMany(mappedBy = "dosen")
    private List<Nilai> daftarNilai = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    @Column(name = "jenis_kelamin")
    private GenderType jenis_kelamin;

    public GenderType getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(GenderType jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Dosen(Long nip) {
        this.nip = nip;
    }

    public Dosen() {
    }

    public List<Nilai> getDaftarNilai() {
        return daftarNilai;
    }

    public void setDaftarNilai(List<Nilai> daftarNilai) {
        this.daftarNilai = daftarNilai;
    }

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}
