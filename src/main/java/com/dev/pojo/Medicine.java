/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thanh_Tam
 */
@Entity
@Table(name = "medicine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicine.findAll", query = "SELECT m FROM Medicine m"),
    @NamedQuery(name = "Medicine.findById", query = "SELECT m FROM Medicine m WHERE m.id = :id"),
    @NamedQuery(name = "Medicine.findByMedicineName", query = "SELECT m FROM Medicine m WHERE m.medicineName = :medicineName"),
    @NamedQuery(name = "Medicine.findByHowToUse", query = "SELECT m FROM Medicine m WHERE m.howToUse = :howToUse"),
    @NamedQuery(name = "Medicine.findByMedicinePrice", query = "SELECT m FROM Medicine m WHERE m.medicinePrice = :medicinePrice"),
    @NamedQuery(name = "Medicine.findByActive", query = "SELECT m FROM Medicine m WHERE m.active = :active")})
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Size(min = 1, max = 45, message = "{medicine.name.nullErr}")
    @Column(name = "medicine_name")
    private String medicineName;

    @Size(min = 1, max = 255, message = "{medicine.howtouse.nullErr}")
    @Column(name = "how_to_use")
    private String howToUse;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @NotNull(message = "{medicine.price.nullErr}")
    @Column(name = "medicine_price")
    @Min(value = 0, message = "{medicine.price.minErr}")
    @Max(value = 100000000, message = "{medicine.price.maxErr}")
    private Float medicinePrice;

    @NotNull(message = "{medicine.quantity.nullErr}")
    @Column(name = "medicine_quantity")
    private Integer medicineQuantity;

    @Column(name = "active")
    private Boolean active;

    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Unit unitId;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId", fetch = FetchType.LAZY)
    private Set<PrescriptionDetail> prescriptionDetailSet;

    public Medicine() {
    }

    public Medicine(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getHowToUse() {
        return howToUse;
    }

    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }

    public Float getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Float medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
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
        if (!(object instanceof Medicine)) {
            return false;
        }
        Medicine other = (Medicine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dev.pojo.Medicine[ id=" + id + " ]";
    }

    /**
     * @return the medicineQuantity
     */
    public Integer getMedicineQuantity() {
        return medicineQuantity;
    }

    /**
     * @param medicineQuantity the medicineQuantity to set
     */
    public void setMedicineQuantity(Integer medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

}
