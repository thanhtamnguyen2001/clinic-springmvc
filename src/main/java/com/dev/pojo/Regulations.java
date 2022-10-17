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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thanh_Tam
 */
@Entity
@Table(name = "regulations")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Regulations.findAll", query = "SELECT r FROM Regulations r"),
        @NamedQuery(name = "Regulations.findById", query = "SELECT r FROM Regulations r WHERE r.id = :id"),
        @NamedQuery(name = "Regulations.findByPatientQuantity", query = "SELECT r FROM Regulations r WHERE r.patientQuantity = :patientQuantity"),
        @NamedQuery(name = "Regulations.findByExaminationPrice", query = "SELECT r FROM Regulations r WHERE r.examinationPrice = :examinationPrice"),
        @NamedQuery(name = "Regulations.findByActive", query = "SELECT r FROM Regulations r WHERE r.active = :active"),
        @NamedQuery(name = "Regulations.findByCreatedDate", query = "SELECT r FROM Regulations r WHERE r.createdDate = :createdDate")})
public class Regulations implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        
	@NotNull(message = "{regulation.patientQuantity.nullErr}")
        @Column(name = "patient_quantity")
        private Integer patientQuantity;
        
        // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
        @NotNull(message = "{regulation.examinationPrice.nullErr}")
	@Column(name = "examination_price")
        private Float examinationPrice;
        
        @Column(name = "active")
        private Boolean active;
        
        @Column(name = "created_date")
        @Temporal(TemporalType.TIMESTAMP)
        private Date createdDate = new Date();
        
        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "regulationId", fetch = FetchType.LAZY)
        private Set<MedicalCertificate> medicalCertificateSet;
        
        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "regulationId", fetch = FetchType.LAZY)
        private Set<Receipt> receiptSet;

        public Regulations() {
        }

        public Regulations(Integer id) {
                this.id = id;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Integer getPatientQuantity() {
                return patientQuantity;
        }

        public void setPatientQuantity(Integer patientQuantity) {
                this.patientQuantity = patientQuantity;
        }

        public Float getExaminationPrice() {
                return examinationPrice;
        }

        public void setExaminationPrice(Float examinationPrice) {
                this.examinationPrice = examinationPrice;
        }

        public Boolean getActive() {
                return active;
        }

        public void setActive(Boolean active) {
                this.active = active;
        }

        public Date getCreatedDate() {
                return createdDate;
        }

        public void setCreatedDate(Date createdDate) {
                this.createdDate = createdDate;
        }

        @XmlTransient
        public Set<MedicalCertificate> getMedicalCertificateSet() {
                return medicalCertificateSet;
        }

        public void setMedicalCertificateSet(Set<MedicalCertificate> medicalCertificateSet) {
                this.medicalCertificateSet = medicalCertificateSet;
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
                if (!(object instanceof Regulations)) {
                        return false;
                }
                Regulations other = (Regulations) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.Regulations[ id=" + id + " ]";
        }

    /**
     * @return the receiptSet
     */
    public Set<Receipt> getReceiptSet() {
        return receiptSet;
    }

    /**
     * @param receiptSet the receiptSet to set
     */
    public void setReceiptSet(Set<Receipt> receiptSet) {
        this.receiptSet = receiptSet;
    }
        
}
