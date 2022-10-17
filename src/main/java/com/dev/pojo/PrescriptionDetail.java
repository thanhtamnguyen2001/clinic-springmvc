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
@Table(name = "prescription_detail")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PrescriptionDetail.findAll", query = "SELECT p FROM PrescriptionDetail p"),
        @NamedQuery(name = "PrescriptionDetail.findById", query = "SELECT p FROM PrescriptionDetail p WHERE p.id = :id"),
        @NamedQuery(name = "PrescriptionDetail.findByMedicineQuantity", query = "SELECT p FROM PrescriptionDetail p WHERE p.medicineQuantity = :medicineQuantity")})
public class PrescriptionDetail implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        
        @Column(name = "medicine_quantity")
        private Integer medicineQuantity;
        
        @JoinColumn(name = "medicine_id", referencedColumnName = "id")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private Medicine medicineId;
        
        @JoinColumn(name = "prescription_id", referencedColumnName = "id")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private Prescription prescriptionId;

        public PrescriptionDetail() {
        }

        public PrescriptionDetail(Integer id) {
                this.id = id;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Integer getMedicineQuantity() {
                return medicineQuantity;
        }

        public void setMedicineQuantity(Integer medicineQuantity) {
                this.medicineQuantity = medicineQuantity;
        }

        public Medicine getMedicineId() {
                return medicineId;
        }

        public void setMedicineId(Medicine medicineId) {
                this.medicineId = medicineId;
        }

        public Prescription getPrescriptionId() {
                return prescriptionId;
        }

        public void setPrescriptionId(Prescription prescriptionId) {
                this.prescriptionId = prescriptionId;
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
                if (!(object instanceof PrescriptionDetail)) {
                        return false;
                }
                PrescriptionDetail other = (PrescriptionDetail) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.PrescriptionDetail[ id=" + id + " ]";
        }
        
}
