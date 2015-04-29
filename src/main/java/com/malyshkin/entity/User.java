package com.malyshkin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1480589175037914639L;

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private long id;

    private String email;

    private String password;

    private boolean familyAdmin;

    @ManyToOne
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Category.class, mappedBy = "user")
    private List<Category> categories;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = FamilyInvite.class, mappedBy = "user")
    private List<FamilyInvite> familyInvites;

    @ManyToOne
    private Family family;

    public User() {
    }

    public User(long id, String login, String password, String email,
           Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Family getFamily()
    {
        return family;
    }

    public void setFamily(Family family)
    {
        this.family = family;
    }

    public List<FamilyInvite> getFamilyInvites()
    {
        return familyInvites;
    }

    public void setFamilyInvites(List<FamilyInvite> familyInvites)
    {
        this.familyInvites = familyInvites;
    }

    public boolean isFamilyAdmin()
    {
        return familyAdmin;
    }

    public void setFamilyAdmin(boolean familyAdmin)
    {
        this.familyAdmin = familyAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", categories=" + categories +
                '}';
    }
}
