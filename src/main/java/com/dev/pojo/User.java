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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thanh_Tam
 */
@Entity
@Table(name = "user")
@XmlRootElement
public class User implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        
        @Size(max = 20, message = "{user.firstname.nullErr}")
        @Column(name = "first_name")
        private String firstName;
        
        @Size(max = 20, message = "{user.lastname.nullErr}")
        @Column(name = "last_name")
        private String lastName;
        
        @Size(max = 20, message = "{user.phone.nullErr}")
        @Column(name = "phone_number")
        private String phoneNumber;
        
        @NotNull(message = "{user.birthdate.nullErr}")
        @Column(name = "date_of_birth")
        @Temporal(TemporalType.TIMESTAMP)
        private Date dateOfBirth;
        
        @Size(max = 3)
        @Column(name = "sex")
        private String sex;
        
        @Size(max = 20, message = "{user.identify.nullErr}", min = 1)
        @Column(name = "identifier")
        private String identifier;
        
        @Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 45, message = "{user.username.nullErr}")
        @Column(name = "username")
        private String username;
        
        @Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 100, message = "{user.password.nullErr}")
        @Column(name = "password")
        private String password;
        
        @Column(name = "active")
        private Boolean active;
        
        @Column(name = "created_date")
        @Temporal(TemporalType.TIMESTAMP)
        private Date createdDate = new Date();
        
        @Size(max = 255, message = "{user.avatar.nullErr}")
        @Column(name = "avatar")
        private String avatar;
        
        // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
        @Size(max = 100, message = "{user.email.nullErr}")
        @Column(name = "email")
        private String email;
        
        @JsonIgnore
        @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
        private Set<MedicalRegister> medicalRegisterSet;
        
        @JsonIgnore
        @OneToMany(cascade = CascadeType.DETACH, mappedBy = "userId", fetch = FetchType.LAZY)
        private Set<Prescription> prescriptionSet;
        
        @JoinColumn(name = "user_role_id", referencedColumnName = "id")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private UserRole userRoleId;
        
        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
        private Set<Receipt> receiptSet;
        
        @JsonIgnore
        @Transient
        private String confirmPassword;
        
        @JsonIgnore
        @Transient
        private MultipartFile image;
        
        @JsonIgnore
        @Transient
        private  String dateString;

        public User() {
        }

        public User(Integer id) {
                this.id = id;
        }

        public User(Integer id, String username, String password) {
                this.id = id;
                this.username = username;
                this.password = password;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public Date getDateOfBirth() {
                return dateOfBirth;
        }

        public void setDateOfBirth(Date dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
        }

        public String getSex() {
                return sex;
        }

        public void setSex(String sex) {
                this.sex = sex;
        }

        public String getIdentifier() {
                return identifier;
        }

        public void setIdentifier(String identifier) {
                this.identifier = identifier;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
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

        public String getAvatar() {
                return avatar;
        }

        public void setAvatar(String avatar) {
                this.avatar = avatar;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        @XmlTransient
        public Set<MedicalRegister> getMedicalRegisterSet() {
                return medicalRegisterSet;
        }

        public void setMedicalRegisterSet(Set<MedicalRegister> medicalRegisterSet) {
                this.medicalRegisterSet = medicalRegisterSet;
        }

        @XmlTransient
        public Set<Prescription> getPrescriptionSet() {
                return prescriptionSet;
        }

        public void setPrescriptionSet(Set<Prescription> prescriptionSet) {
                this.prescriptionSet = prescriptionSet;
        }

        public UserRole getUserRoleId() {
                return userRoleId;
        }

        public void setUserRoleId(UserRole userRoleId) {
                this.userRoleId = userRoleId;
        }
        
        /**
         * @return the image
         */
        public MultipartFile getImage() {
                return image;
        }

        /**
         * @param image the image to set
         */
        public void setImage(MultipartFile image) {
                this.image = image;
        }


        /**
         * @return the confirmPassword
         */
        public String getConfirmPassword() {
                return confirmPassword;
        }

        /**
         * @param confirmPassword the confirmPassword to set
         */
        public void setConfirmPassword(String confirmPassword) {
                this.confirmPassword = confirmPassword;
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
                if (!(object instanceof User)) {
                        return false;
                }
                User other = (User) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.User[ id=" + id + " ]";
        }

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
