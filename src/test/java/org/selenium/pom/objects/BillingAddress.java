package org.selenium.pom.objects;

import org.selenium.pom.pages.CheckoutPage;

public class BillingAddress {

    public BillingAddress(){}

    public BillingAddress(String firstName,String lastName, String addressLine, String townOrCity,String zipCode, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine = addressLine;
        this.townOrCity = townOrCity;
        this.zipCode = zipCode;
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public BillingAddress setAddressLine(String addressLine) {
        this.addressLine = addressLine;
        return this;
    }

    public String getTownOrCity() {
        return townOrCity;
    }

    public BillingAddress setTownOrCity(String townOrCity) {
        this.townOrCity = townOrCity;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public BillingAddress setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }

    private String firstName;
    private String lastName;
    private String addressLine;
    private String townOrCity;
    private String zipCode;
    private String email;
}
