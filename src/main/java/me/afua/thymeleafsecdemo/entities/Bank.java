package me.afua.thymeleafsecdemo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;


    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @NotNull
    private double withdrawalamount;

    public double getWithdrawalamount() {
        return withdrawalamount;
    }

    public void setWithdrawalamount(double withdrawalamount) {
        this.withdrawalamount = withdrawalamount;
    }

    @NotNull
    private double depositeamount;

    public double getDepositeamount() {
        return depositeamount;
    }

    public void setDepositeamount(double depositeamount) {
        this.depositeamount = depositeamount;
    }

    @NotNull
    private long accountnumber;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }
}