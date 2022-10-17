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
@Table(name = "user_role")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u"),
        @NamedQuery(name = "UserRole.findById", query = "SELECT u FROM UserRole u WHERE u.id = :id"),
        @NamedQuery(name = "UserRole.findByName", query = "SELECT u FROM UserRole u WHERE u.name = :name")})
public class UserRole implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        
        @Size(max = 45)
        @Column(name = "name")
        private String name;

        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId", fetch = FetchType.LAZY)
        private Set<User> userSet;

        public UserRole() {
        }

        public UserRole(Integer id) {
                this.id = id;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        @XmlTransient
        public Set<User> getUserSet() {
                return userSet;
        }

        public void setUserSet(Set<User> userSet) {
                this.userSet = userSet;
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
                if (!(object instanceof UserRole)) {
                        return false;
                }
                UserRole other = (UserRole) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.UserRole[ id=" + id + " ]";
        }

}
