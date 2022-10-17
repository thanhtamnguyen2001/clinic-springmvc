/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Thanh_Tam
 */
@Entity
@Table(name = "prescription")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p"),
        @NamedQuery(name = "Prescription.findById", query = "SELECT p FROM Prescription p WHERE p.id = :id"),
        @NamedQuery(name = "Prescription.findByCreatedDate", query = "SELECT p FROM Prescription p WHERE p.createdDate = :createdDate")})
public class Prescription implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        
        @Column(name = "created_date")
        @Temporal(TemporalType.TIMESTAMP)
        private Date createdDate = new Date();
        
        
        @JoinColumn(name = "medical_certificate_id", referencedColumnName = "id")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private MedicalCertificate medicalCertificateId;
        
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
        private User userId;
        
        @JsonIgnore
        @OneToMany(cascade = CascadeType.DETACH, mappedBy = "prescriptionId", fetch = FetchType.LAZY)
        private Set<PrescriptionDetail> prescriptionDetailSet;

        public Prescription() {
        }

        public Prescription(Integer id) {
                this.id = id;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Date getCreatedDate() {
                return createdDate;
        }

        public void setCreatedDate(Date createdDate) {
                this.createdDate = createdDate;
        }

        public MedicalCertificate getMedicalCertificateId() {
                return medicalCertificateId;
        }

        public void setMedicalCertificateId(MedicalCertificate medicalCertificateId) {
                this.medicalCertificateId = medicalCertificateId;
        }

        public User getUserId() {
                return userId;
        }

        public void setUserId(User userId) {
                this.userId = userId;
        }

        @XmlTransient
        public Set<PrescriptionDetail> getPrescriptionDetailSet() {
                return prescriptionDetailSet;
        }

        public void setPrescriptionDetailSet(Set<PrescriptionDetail> prescriptionDetailSet) {
                this.prescriptionDetailSet = prescriptionDetailSet;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (id != null ? id.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof Prescription)) {
                        return false;
                }
                Prescription other = (Prescription) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.Prescription[ id=" + id + " ]";
        }
        
}
