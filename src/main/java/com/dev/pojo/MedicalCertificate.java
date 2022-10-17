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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thanh_Tam
 */
@Entity
@Table(name = "medical_certificate")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MedicalCertificate.findAll", query = "SELECT m FROM MedicalCertificate m"),
        @NamedQuery(name = "MedicalCertificate.findById", query = "SELECT m FROM MedicalCertificate m WHERE m.id = :id"),
        @NamedQuery(name = "MedicalCertificate.findByDateOfExamination", query = "SELECT m FROM MedicalCertificate m WHERE m.dateOfExamination = :dateOfExamination"),
        @NamedQuery(name = "MedicalCertificate.findBySymptom", query = "SELECT m FROM MedicalCertificate m WHERE m.symptom = :symptom"),
        @NamedQuery(name = "MedicalCertificate.findByConclusion", query = "SELECT m FROM MedicalCertificate m WHERE m.conclusion = :conclusion")})
public class MedicalCertificate implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        
        @Column(name = "date_of_examination")
        @Temporal(TemporalType.DATE)
        private Date dateOfExamination = new Date();
        
        @Size(min = 1, max = 100, message = "{medicalCertificate.symptom.nullErr}")
        @Column(name = "symptom")
        private String symptom;
        
        @Size(min = 1, max = 100, message = "{medicalCertificate.conclusion.nullErr}")
        @Column(name = "conclusion")
        private String conclusion;
        
        @JsonIgnore
        @OneToMany(cascade = CascadeType.DETACH, mappedBy = "medicalCertificateId", fetch = FetchType.EAGER)
        private Set<Prescription> prescriptionSet;
        
        @JoinColumn(name = "medical_register_id", referencedColumnName = "id")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private MedicalRegister medicalRegisterId;
        
        @JoinColumn(name = "regulation_id", referencedColumnName = "id")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private Regulations regulationId;
        
        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalCertificateId", fetch = FetchType.LAZY)
        private Set<Diagnostic> diagnosticSet;
        

        public MedicalCertificate() {
        }

        public MedicalCertificate(Integer id) {
                this.id = id;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Date getDateOfExamination() {
                return dateOfExamination;
        }

        public void setDateOfExamination(Date dateOfExamination) {
                this.dateOfExamination = dateOfExamination;
        }

        public String getSymptom() {
                return symptom;
        }

        public void setSymptom(String symptom) {
                this.symptom = symptom;
        }

        public String getConclusion() {
                return conclusion;
        }

        public void setConclusion(String conclusion) {
                this.conclusion = conclusion;
        }

        @XmlTransient
        public Set<Prescription> getPrescriptionSet() {
                return prescriptionSet;
        }

        public void setPrescriptionSet(Set<Prescription> prescriptionSet) {
                this.prescriptionSet = prescriptionSet;
        }

        public MedicalRegister getMedicalRegisterId() {
                return medicalRegisterId;
        }

        public void setMedicalRegisterId(MedicalRegister medicalRegisterId) {
                this.medicalRegisterId = medicalRegisterId;
        }

        public Regulations getRegulationId() {
                return regulationId;
        }

        public void setRegulationId(Regulations regulationId) {
                this.regulationId = regulationId;
        }

        @XmlTransient
        public Set<Diagnostic> getDiagnosticSet() {
                return diagnosticSet;
        }

        public void setDiagnosticSet(Set<Diagnostic> diagnosticSet) {
                this.diagnosticSet = diagnosticSet;
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
                if (!(object instanceof MedicalCertificate)) {
                        return false;
                }
                MedicalCertificate other = (MedicalCertificate) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.MedicalCertificate[ id=" + id + " ]";
        }
        
}
