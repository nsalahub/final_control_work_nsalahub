package com.gmail.nikolay.salahub.springbootmodule.repository.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "BusinessCard")
@SQLDelete(sql =
        "UPDATE BusinessCard " +
                "SET b_deleted = 1 " +
                "WHERE b_id = ?")
@Where(clause = "b_deleted = 0")
public class BusinessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_id")
    private Long id;
    @Column(name = "b_title")
    private String title;
    @Column(name = "b_full_name")
    private String fullName;
    @Column(name = "b_working_telephone")
    private String telephone;
    @Column(name = "b_deleted")
    private boolean isDeleted;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "b_user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessCard that = (BusinessCard) o;
        return isDeleted == that.isDeleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(user.getId(), that.user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, fullName, telephone, isDeleted, user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
