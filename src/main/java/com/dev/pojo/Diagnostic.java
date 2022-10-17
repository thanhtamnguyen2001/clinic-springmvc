/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thanh_Tam
 */
@Entity
@Table(name = "diagnostic")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Diagnostic.findAll", query = "SELECT d FROM Diagnostic d"),
        @NamedQuery(name = "Diagnostic.findById", query = "SELECT d FROM Diagnostic d WHERE d.id = :id")})
public class Diagnostic implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        @JoinColumn(name = "disease_id", referencedColumnName = "id")
        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        private Disease diseaseId;
        @JoinColumn(name = "medical_certificate_id", referencedColumnName = "id")
        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        private MedicalCertificate medicalCertificateId;

        public Diagnostic() {
        }

        public Diagnostic(Integer id) {
                this.id = id;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Disease getDiseaseId() {
                return diseaseId;
        }

        public void setDiseaseId(Disease diseaseId) {
                this.diseaseId = diseaseId;
        }

        public MedicalCertificate getMedicalCertificateId() {
                return medicalCertificateId;
        }

        public void setMedicalCertificateId(MedicalCertificate medicalCertificateId) {
                this.medicalCertificateId = medicalCertificateId;
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
                if (!(object instanceof Diagnostic)) {
                        return false;
                }
                Diagnostic other = (Diagnostic) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.Diagnostic[ id=" + id + " ]";
        }
        
}
