/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo22.hotelinggrupo22.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Jairo
 */
@Entity
@Table(name = "userrelation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userrelation.findAll", query = "SELECT u FROM Userrelation u"),
    @NamedQuery(name = "Userrelation.findById", query = "SELECT u FROM Userrelation u WHERE u.id = :id")})
public class Userrelation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "clgroup", referencedColumnName = "groupid")
    @ManyToOne(optional = false)
    private UserGroups clgroup;
    @JoinColumn(name = "client", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Users client;

    public Userrelation() {
    }

    public Userrelation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserGroups getClgroup() {
        return clgroup;
    }

    public void setClgroup(UserGroups clgroup) {
        this.clgroup = clgroup;
    }

    public Users getClient() {
        return client;
    }

    public void setClient(Users client) {
        this.client = client;
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
        if (!(object instanceof Userrelation)) {
            return false;
        }
        Userrelation other = (Userrelation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo22.hotelinggrupo22.entities.Userrelation[ id=" + id + " ]";
    }
    
}
