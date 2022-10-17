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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thanh_Tam
 */
@Entity
@Table(name = "disease")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Disease.findAll", query = "SELECT d FROM Disease d"),
        @NamedQuery(name = "Disease.findById", query = "SELECT d FROM Disease d WHERE d.id = :id"),
        @NamedQuery(name = "Disease.findByDiseaseName", query = "SELECT d FROM Disease d WHERE d.diseaseName = :diseaseName")})
public class Disease implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;

        @Size(min = 1, max = 100, message = "{disease.diseaseName.nullErr}")
        @Column(name = "disease_name")
        private String diseaseName;
	
	@JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "diseaseId", fetch = FetchType.LAZY)
        private Set<Diagnostic> diagnosticSet;

        public Disease() {
        }

        public Disease(Integer id) {
                this.id = id;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getDiseaseName() {
                return diseaseName;
        }

        public void setDiseaseName(String diseaseName) {
                this.diseaseName = diseaseName;
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
                if (!(object instanceof Disease)) {
                        return false;
                }
                Disease other = (Disease) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.Disease[ id=" + id + " ]";
        }
        
}
