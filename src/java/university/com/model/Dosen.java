/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iman
 */
@Entity
@Table(name = "dosen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dosen.findAll", query = "SELECT d FROM Dosen d"),
    @NamedQuery(name = "Dosen.findByNip", query = "SELECT d FROM Dosen d WHERE d.nip = :nip"),
    @NamedQuery(name = "Dosen.findByNmDosen", query = "SELECT d FROM Dosen d WHERE d.nmDosen = :nmDosen"),
    @NamedQuery(name = "Dosen.findByAlamat", query = "SELECT d FROM Dosen d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Dosen.findByTanggalLahir", query = "SELECT d FROM Dosen d WHERE d.tanggalLahir = :tanggalLahir"),
    @NamedQuery(name = "Dosen.findByJenisKelamin", query = "SELECT d FROM Dosen d WHERE d.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Dosen.findByImg", query = "SELECT d FROM Dosen d WHERE d.img = :img")})
public class Dosen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nip")
    private Long nip;
    @Column(name = "nm_dosen")
    private String nmDosen;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    @Column(name = "jenis_kelamin")
    private Character jenisKelamin;
    @Column(name = "img")
    private BigInteger img;
    @OneToMany(mappedBy = "nip")
    private Collection<Nilai> nilaiCollection;

    public Dosen() {
    }

    public Dosen(Long nip) {
        this.nip = nip;
    }

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
    }

    public String getNmDosen() {
        return nmDosen;
    }

    public void setNmDosen(String nmDosen) {
        this.nmDosen = nmDosen;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public BigInteger getImg() {
        return img;
    }

    public void setImg(BigInteger img) {
        this.img = img;
    }

    @XmlTransient
    public Collection<Nilai> getNilaiCollection() {
        return nilaiCollection;
    }

    public void setNilaiCollection(Collection<Nilai> nilaiCollection) {
        this.nilaiCollection = nilaiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nip != null ? nip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dosen)) {
            return false;
        }
        Dosen other = (Dosen) object;
        if ((this.nip == null && other.nip != null) || (this.nip != null && !this.nip.equals(other.nip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "university.com.model.Dosen[ nip=" + nip + " ]";
    }
    
}
