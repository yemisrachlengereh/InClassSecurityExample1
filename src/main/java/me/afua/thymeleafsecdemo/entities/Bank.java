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
    private long id;


    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @NotNull

   private String withdrawalamount;
    @NotNull
    private String depositeamount;

    @NotNull
    private long accountnumber;

    public String getWithdrawalamount() {
        return withdrawalamount;
    }

    public void setWithdrawalamount(String withdrawalamount) {
        this.withdrawalamount = withdrawalamount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepositeamount() {
        return depositeamount;
    }

    public void setDepositeamount(String depositeamount) {
        this.depositeamount = depositeamount;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }
}