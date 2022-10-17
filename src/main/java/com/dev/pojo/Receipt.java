/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.pojo;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "receipt")
public class Receipt {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @Column(name = "is_payment")
    private Boolean isPayment;

    @NotNull(message = "{medicine.price.nullErr}")
    @Column(name = "price_total")
    @Min(value = 0, message = "{medicine.price.minErr}")
    @Max(value = 100000000, message = "{medicine.price.maxErr}")
    private Float priceTotal;
    
//    @JoinColumn(name = "medical_certificate_id", referencedColumnName = "id")
//    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    private MedicalCertificate medicalCertificateId;
    
    @JoinColumn(name = "regulation_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Regulations regulationId;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User userId;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the isPayment
     */
    public Boolean getIsPayment() {
        return isPayment;
    }

    /**
     * @param isPayment the isPayment to set
     */
    public void setIsPayment(Boolean isPayment) {
        this.isPayment = isPayment;
    }

    /**
     * @return the priceTotal
     */
    public Float getPriceTotal() {
        return priceTotal;
    }

    /**
     * @param priceTotal the priceTotal to set
     */
    public void setPriceTotal(Float priceTotal) {
        this.priceTotal = priceTotal;
    }

    /**
     * @return the medicalCertificateId
     */
//    public MedicalCertificate getMedicalCertificateId() {
//        return medicalCertificateId;
//    }
//
//    /**
//     * @param medicalCertificateId the medicalCertificateId to set
//     */
//    public void setMedicalCertificateId(MedicalCertificate medicalCertificateId) {
//        this.medicalCertificateId = medicalCertificateId;
//    }

    /**
     * @return the regulationId
     */
    public Regulations getRegulationId() {
        return regulationId;
    }

    /**
     * @param regulationId the regulationId to set
     */
    public void setRegulationId(Regulations regulationId) {
        this.regulationId = regulationId;
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }
}
