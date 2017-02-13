/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iman
 */
@Entity
@Table(name = "nilai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nilai.findAll", query = "SELECT n FROM Nilai n"),
    @NamedQuery(name = "Nilai.findByIdNilai", query = "SELECT n FROM Nilai n WHERE n.idNilai = :idNilai")})
public class Nilai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_nilai")
    private Long idNilai;
    @JoinColumn(name = "nip", referencedColumnName = "nip")
    @ManyToOne
    private Dosen nip;
    @JoinColumn(name = "npm", referencedColumnName = "npm")
    @ManyToOne
    private Mahasiswa npm;
    @JoinColumn(name = "kode", referencedColumnName = "kode")
    @ManyToOne
    private Matakuliah kode;

    public Nilai() {
    }

    public Nilai(Long idNilai) {
        this.idNilai = idNilai;
    }

    public Long getIdNilai() {
        return idNilai;
    }

    public void setIdNilai(Long idNilai) {
        this.idNilai = idNilai;
    }

    public Dosen getNip() {
        return nip;
    }

    public void setNip(Dosen nip) {
        this.nip = nip;
    }

    public Mahasiswa getNpm() {
        return npm;
    }

    public void setNpm(Mahasiswa npm) {
        this.npm = npm;
    }

    public Matakuliah getKode() {
        return kode;
    }

    public void setKode(Matakuliah kode) {
        this.kode = kode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNilai != null ? idNilai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nilai)) {
            return false;
        }
        Nilai other = (Nilai) object;
        if ((this.idNilai == null && other.idNilai != null) || (this.idNilai != null && !this.idNilai.equals(other.idNilai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "university.com.model.Nilai[ idNilai=" + idNilai + " ]";
    }
    
}
