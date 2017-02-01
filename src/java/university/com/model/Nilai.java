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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author iman
 */
@Entity
@Table(name = "nilai")
public class Nilai implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_nilai")
    private Long id_nilai;

    @ManyToOne()
    @JoinColumn(name = "nip" )
    private Dosen dosen;

    @ManyToOne
    @JoinColumn(name = "kode")
    private MataKuliah mataKuliah;

    @ManyToOne()
    @JoinColumn(name = "npm")
    private Mahasiswa mahasiswa;

    @Column(name = "nilai" ,nullable = true)
    private double nilai;

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public Long getId_nilai() {
        return id_nilai;
    }

    public void setId_nilai(Long id_nilai) {
        this.id_nilai = id_nilai;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

}
