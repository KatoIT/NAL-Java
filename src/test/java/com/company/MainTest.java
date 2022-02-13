package com.company;

import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    PhoneManager phoneManager;
    GenuinePhone genuinePhone = new GenuinePhone(1,
            "Samsung S9",
            1000000.0,
            10,
            "Samsung",
            365,
            "Toan Quoc");
    CellPhone cellPhone = new CellPhone(0,
            "Samsung S9",
            1000000.0,
            10,
            "Samsung",
            "China",
            "Da sua chua");

    @BeforeEach
    void start() {
        phoneManager = new PhoneManager();
        phoneManager.insertPhone(cellPhone);
        phoneManager.insertPhone(genuinePhone);
    }

    @Test
    void addCellPhoneSuccessful() {
        boolean expected = true;
        boolean result = phoneManager.insertPhone(cellPhone);
        assertEquals(expected, result);
    }


    @Test
    void addGenuinePhoneSuccessful() {
        boolean expected = true;
        boolean result = phoneManager.insertPhone(genuinePhone);
        assertEquals(expected, result);
    }


    @Test
    void deletePhoneSuccessful() {
        boolean expected = true;
        boolean result = phoneManager.deletePhone(genuinePhone);
        assertEquals(expected, result);
    }

    @Test
    void deletePhoneFail() {
        boolean expected = false;
        boolean result = phoneManager.deletePhone(new GenuinePhone(1,
                "Samsung S9",
                1000000.0,
                10,
                "Samsung",
                1000,
                "Viet Nam"));
        assertEquals(expected, result);
    }

    @Test
    void searchPhoneById() {
        int expected = cellPhone.id;
        int result = phoneManager.findById(cellPhone.id).id;
        assertEquals(expected, result);
    }


    @Test
    @DisplayName("Price = 100")
    void validatePriceSuccessful() {
        boolean expected = true;
        boolean result = Main.validatePrice(100);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Price = -100")
    void validatePriceFail() {
        boolean expected = false;
        boolean result = Main.validatePrice(-100);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Quantity = 100")
    void validateQuantitySuccessful() {
        boolean expected = true;
        boolean result = Main.validateQuantity(100);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Quantity = -100")
    void validateQuantityFail() {
        boolean expected = false;
        boolean result = Main.validateQuantity(-100);
        assertEquals(expected, result);
    }

    @Test
    void validateCountrySuccessful() {
        boolean expected = true;
        boolean result = Main.validateCountry("China");
        assertEquals(expected, result);
    }

    @Test
    void validateCountryFail() {
        boolean expected = false;
        boolean result = Main.validateCountry("Viet Nam");
        assertEquals(expected, result);
    }

    @Test
    void validateStatusSuccessful() {
        boolean expected = true;
        boolean result = Main.validateStatus("Da sua chua");
        assertEquals(expected, result);
    }

    @Test
    void validateStatusFail() {
        boolean expected = false;
        boolean result = Main.validateStatus("Da sua");
        assertEquals(expected, result);
    }

    @Test
    void validateWarrantyPeriodSuccessful() {
        boolean expected = true;
        boolean result = Main.validateWarrantyPeriod(100);
        assertEquals(expected, result);
    }

    @Test
    void validateWarrantyPeriodFail() {
        boolean expected = false;
        boolean result = Main.validateWarrantyPeriod(-100);
        assertEquals(expected, result);
    }

    @Test
    void validateWarrantyCoverageSuccessful() {
        boolean expected = true;
        boolean result = Main.validateWarrantyCoverage("Toan Quoc");
        assertEquals(expected, result);
    }

    @Test
    void validateWarrantyCoverageFail() {
        boolean expected = false;
        boolean result = Main.validateWarrantyCoverage("Ca nuoc");
        assertEquals(expected, result);
    }
}