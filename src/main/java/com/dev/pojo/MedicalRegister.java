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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thanh_Tam
 */
@Entity
@Table(name = "medical_register")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MedicalRegister.findAll", query = "SELECT m FROM MedicalRegister m"),
        @NamedQuery(name = "MedicalRegister.findById", query = "SELECT m FROM MedicalRegister m WHERE m.id = :id"),
        @NamedQuery(name = "MedicalRegister.findByDateOfExamination", query = "SELECT m FROM MedicalRegister m WHERE m.dateOfExamination = :dateOfExamination"),
        @NamedQuery(name = "MedicalRegister.findByPatientName", query = "SELECT m FROM MedicalRegister m WHERE m.patientName = :patientName"),
        @NamedQuery(name = "MedicalRegister.findByEmail", query = "SELECT m FROM MedicalRegister m WHERE m.email = :email"),
        @NamedQuery(name = "MedicalRegister.findByPhoneNumber", query = "SELECT m FROM MedicalRegister m WHERE m.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "MedicalRegister.findByHealthIssues", query = "SELECT m FROM MedicalRegister m WHERE m.healthIssues = :healthIssues"),
        @NamedQuery(name = "MedicalRegister.findByIsVerified", query = "SELECT m FROM MedicalRegister m WHERE m.isVerified = :isVerified")})
public class MedicalRegister implements Serializable {

        /**
         * @return the dateString
         */
        public String getDateString() {
                return dateString;
        }

        /**
         * @param dateString the dateString to set
         */
        public void setDateString(String dateString) {
                this.dateString = dateString;
        }

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        
        @Column(name = "date_of_examination")
        @Temporal(TemporalType.DATE)
        private Date dateOfExamination;
        
        @Size(max = 100)
        @Column(name = "patient_name")
        private String patientName;
        
        // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
        @Size(max = 100)
        @Column(name = "email")
        private String email;
        
        @Basic(optional = false)
        @NotNull
        @Column(name = "phone_number")
        private int phoneNumber;
        
        @Size(max = 255)
        @Column(name = "health_issues")
        private String healthIssues;
        
        @Column(name = "is_verified")
        private Boolean isVerified;
        
        @JsonIgnore
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
        private User userId;
        
        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalRegisterId", fetch = FetchType.LAZY)
        private Set<MedicalCertificate> medicalCertificateSet;
        
        @JsonIgnore
        @Transient
        private  String dateString;

        public MedicalRegister() {
        }

        public MedicalRegister(Integer id) {
                this.id = id;
        }

        public MedicalRegister(Integer id, int phoneNumber) {
                this.id = id;
                this.phoneNumber = phoneNumber;
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

        public String getPatientName() {
                return patientName;
        }

        public void setPatientName(String patientName) {
                this.patientName = patientName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public int getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(int phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public String getHealthIssues() {
                return healthIssues;
        }

        public void setHealthIssues(String healthIssues) {
                this.healthIssues = healthIssues;
        }

        public Boolean getIsVerified() {
                return isVerified;
        }

        public void setIsVerified(Boolean isVerified) {
                this.isVerified = isVerified;
        }

        public User getUserId() {
                return userId;
        }

        public void setUserId(User userId) {
                this.userId = userId;
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
                if (!(object instanceof MedicalRegister)) {
                        return false;
                }
                MedicalRegister other = (MedicalRegister) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.MedicalRegister[ id=" + id + " ]";
        }
        
}
