package org.example.demo.domain;

import org.example.demo.validation.CustomAnnotation;

import javax.validation.constraints.*;

public class Customer {

    @NotNull(message = "Required (may not be null)")
    @Size(min = 1, max = 64, message = "Size must be > 1 and < 65")
    private String firstName;

    @NotNull(message = "Required (may not be null)")
    @Size(min = 1, max = 64, message = "Size must be > 1 and < 65")
    private String lastName;

    @Min(value = 0, message = "must be >=0")
    @Max(value = 10, message = "must be <= 10")
    @NotNull(message = "Required (may not be null)")
    private Integer freePasses;

    @Pattern(regexp = "LV-[0-9]{4}", message = "Zip code should be in format LV-0000")
    @NotNull(message = "Required (may not be null)")
    private String zipCode;

    @CustomAnnotation(value = "Est", message = "Must start with Est")
    private String country;

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
