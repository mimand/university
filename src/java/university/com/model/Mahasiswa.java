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
@Table(name = "mahasiswa")
public class Mahasiswa implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum GenderType {
        Pria,Perempuan;
    }
    @Id
    @Basic(optional = false)
    @Column(name = "npm")
    private Long npm;

    @Column(name = "nama")
    private String nama;

    @Column(name = "kelas")
    private String kelas;

    @Column(name = "jurusan")
    private String jurusan;

    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date tanggal_lahir;

    @Enumerated(EnumType.STRING)
    @Column(name = "jenis_kelamin")
    private GenderType jenis_kelamin;

    public GenderType getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(GenderType jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }
    @OneToMany(mappedBy = "mahasiswa")
    private List<Nilai> daftarNilai = new ArrayList<>();

    public List<Nilai> getDaftarNilai() {
        return daftarNilai;
    }

    public void setDaftarNilai(List<Nilai> daftarNilai) {
        this.daftarNilai = daftarNilai;
    }

    public Mahasiswa() {
    }

    public Mahasiswa(Long npm) {
        this.npm = npm;
    }

    public Long getNpm() {
        return npm;
    }

    public void setNpm(Long npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

}
