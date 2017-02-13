/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iman
 */
@Entity
@Table(name = "mahasiswa")
@XmlRootElement
public class Mahasiswa implements Serializable {

    private static final long serialVersionUID = 1L;
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
    private Date tanggalLahir;

    @Column(name = "jenis_kelamin")
    private Character jenisKelamin;
    @Lob()
    @Column(name = "img")
    private byte[] img;    
    @Transient
    private String byte64Encode;

    public String getByte64Encode() {
        return byte64Encode;
    }

    public void setByte64Encode(String byte64Encode) {
        this.byte64Encode = byte64Encode;
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

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (npm != null ? npm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mahasiswa)) {
            return false;
        }
        Mahasiswa other = (Mahasiswa) object;
        if ((this.npm == null && other.npm != null) || (this.npm != null && !this.npm.equals(other.npm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "university.com.model.Mahasiswa[ npm=" + npm + " ]";
    }
    
}
