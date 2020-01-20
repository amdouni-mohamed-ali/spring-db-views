package com.spring.example.springdbviews.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Account {

    /*
     * check this :
     * https://en.wikibooks.org/wiki/Java_Persistence/ElementCollection
     */

    @Column(name = "first_name")
    private String firstName;
    private Double balance;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "date_opened")
    private String dateOpened;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", balance=" + balance +
                ", accountName='" + accountName + '\'' +
                ", dateOpened='" + dateOpened + '\'' +
                '}';
    }
}
