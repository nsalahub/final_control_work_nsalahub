package com.gmail.nikolay.salahub.springbootmodule.repository.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "User")
@SQLDelete(sql =
        "UPDATE User " +
                "SET u_deleted = 1 " +
                "WHERE u_id = ?")
@Where(clause = "u_deleted = 0")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long id;
    @Column(name= "u_username")
    private String username;
    @Column(name ="u_password")
    private String password;
    @Column(name = "u_deleted")
    private boolean isDeleted;
    @Column(name = "u_role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    List<BusinessCard> businessCards = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isDeleted == user.isDeleted &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                role == user.role &&
                Objects.equals(businessCards, user.businessCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, isDeleted, role, businessCards);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public List<BusinessCard> getBusinessCards() {
        return businessCards;
    }

    public void setBusinessCards(List<BusinessCard> businessCards) {
        this.businessCards = businessCards;
    }
}
