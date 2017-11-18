package me.afua.thymeleafsecdemo.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserData {
    public UserData(){

       this.roles = new HashSet<> ();

    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Email
    @NotEmpty
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private boolean enabled;

    private String username;

    private String reason;

    private String withdrawalamount;

    private String depositeamount;

    public String getTransactionhistory() {
        return transactionhistory;
    }

    public void setTransactionhistory(String transactionhistory) {
        this.transactionhistory = transactionhistory;
    }

    private String accountnumber;

    private String transactionhistory;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWithdrawalamount() {
        return withdrawalamount;
    }

    public void setWithdrawalamount(String withdrawalamount) {
        this.withdrawalamount = withdrawalamount;
    }

    public String getDepositeamount() {
        return depositeamount;
    }

    public void setDepositeamount(String depositeamount) {
        this.depositeamount = depositeamount;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    //The relationship many user's can have many roles each person can have one or more or zero
    @ManyToMany(fetch = FetchType.EAGER)
    //Join Coulnm one it will save for from this table for realtionship to role in database
    @JoinTable(joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<UserRole> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public void addRole(UserRole theRole){
    roles.add ( theRole );

    }
}
