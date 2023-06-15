package com.azin.javaspringboothumanresource.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("2")
@Table(name = "CUSTOMER")
public class Customer extends Com_User{

    @Column(name = "BANK_IBAN")
    private String bankIban;

    @Column(name = "SHARED_KEY")
    private String sharedKey;

    @Column(name = "INTRODUCER_CUSTOMER_ID")
    private int introducerCustomer;

    public String getBankIban() {
        return bankIban;
    }

    public void setBankIban(String bankIban) {
        this.bankIban = bankIban;
    }

    public String getSharedKey() {
        return sharedKey;
    }

    public void setSharedKey(String sharedKey) {
        this.sharedKey = sharedKey;
    }

    public int getIntroducerCustomer() {
        return introducerCustomer;
    }

    public void setIntroducerCustomer(int introducerCustomer) {
        this.introducerCustomer = introducerCustomer;
    }


}
