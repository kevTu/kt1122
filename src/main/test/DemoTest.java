package src.main.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import src.main.java.Checkout;
import src.main.java.Demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class DemoTest {

    static Checkout output1;
    static Checkout output2;
    static Checkout output3;
    static Checkout output4;
    static Checkout output5;
    static Checkout output6;

    @BeforeAll
    static void init() throws Exception {
        output2 = Demo.generateOutput("LADW", "07/02/20", 3, 10);
        output3 = Demo.generateOutput("CHNS", "07/02/15", 5, 25);
        output4 = Demo.generateOutput("JAKD", "09/03/15", 6, 0);
        output5 = Demo.generateOutput("JAKR", "07/02/15", 9, 0);
        output6 = Demo.generateOutput("JAKR", "07/02/20", 4, 50);
    }

    // TEST 1

    @Test
    void test1_whenDiscountPercentOutOfRange_thenExceptionThrown() {
        Exception ex = assertThrows(Exception.class, () -> {
            output1 = Demo.generateOutput("JAKR", "09/03/15", 5, 101);
        });
        String expectedMessage = "Invalid discount percent. Please enter a discount percent in the range of 0 to 100.";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    // TEST 2

    @Test
    void test2_whenCheckoutValid_thenToolCodeAssertionSucceeds() {
        String expectedResult = "LADW";
        String actualResult = output2.getTool().getToolCode();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenToolTypeAssertionSucceeds() {
        String expectedResult = "Ladder";
        String actualResult = output2.getTool().getToolType();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenToolBrandAssertionSucceeds() {
        String expectedResult = "Werner";
        String actualResult = output2.getTool().getBrand();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenRentalDaysAssertionSucceeds() {
        Integer expectedResult = 3;
        Integer actualResult = output2.getRentDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenCheckoutDateAssertionSucceeds() {
        String expectedResult = "07/02/20";
        String actualResult = output2.getCheckoutDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenDueDateAssertionSucceeds() {
        String expectedResult = "07/05/20";
        String actualResult = output2.getDueDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenDailyRentalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(1.99).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output2.getDailyRentalCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenChargeDaysAssertionSucceeds() {
        Integer expectedResult = 2;
        Integer actualResult = output2.getChargeDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenPreDiscountChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(3.98).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output2.getPreDiscountCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenDiscountPercentAssertionSucceeds() {
        Integer expectedResult = 10;
        Integer actualResult = output2.getDiscountPercent();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenDiscountAmountAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(0.40).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output2.getDiscountAmount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test2_whenCheckoutValid_thenFinalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(3.58).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output2.getFinalCharge();
        assertEquals(expectedResult, actualResult);
    }

    // TEST 3

    @Test
    void test3_whenCheckoutValid_thenToolCodeAssertionSucceeds() {
        String expectedResult = "CHNS";
        String actualResult = output3.getTool().getToolCode();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenToolTypeAssertionSucceeds() {
        String expectedResult = "Chainsaw";
        String actualResult = output3.getTool().getToolType();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenToolBrandAssertionSucceeds() {
        String expectedResult = "Stihl";
        String actualResult = output3.getTool().getBrand();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenRentalDaysAssertionSucceeds() {
        Integer expectedResult = 5;
        Integer actualResult = output3.getRentDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenCheckoutDateAssertionSucceeds() {
        String expectedResult = "07/02/15";
        String actualResult = output3.getCheckoutDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenDueDateAssertionSucceeds() {
        String expectedResult = "07/07/15";
        String actualResult = output3.getDueDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenDailyRentalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(1.49).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output3.getDailyRentalCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenChargeDaysAssertionSucceeds() {
        Integer expectedResult = 3;
        Integer actualResult = output3.getChargeDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenPreDiscountChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(4.47).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output3.getPreDiscountCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenDiscountPercentAssertionSucceeds() {
        Integer expectedResult = 25;
        Integer actualResult = output3.getDiscountPercent();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenDiscountAmountAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(1.12).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output3.getDiscountAmount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test3_whenCheckoutValid_thenFinalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(3.35).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output3.getFinalCharge();
        assertEquals(expectedResult, actualResult);
    }

    // TEST 4

    @Test
    void test4_whenCheckoutValid_thenToolCodeAssertionSucceeds() {
        String expectedResult = "JAKD";
        String actualResult = output4.getTool().getToolCode();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenToolTypeAssertionSucceeds() {
        String expectedResult = "Jackhammer";
        String actualResult = output4.getTool().getToolType();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenToolBrandAssertionSucceeds() {
        String expectedResult = "DeWalt";
        String actualResult = output4.getTool().getBrand();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenRentalDaysAssertionSucceeds() {
        Integer expectedResult = 6;
        Integer actualResult = output4.getRentDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenCheckoutDateAssertionSucceeds() {
        String expectedResult = "09/03/15";
        String actualResult = output4.getCheckoutDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenDueDateAssertionSucceeds() {
        String expectedResult = "09/09/15";
        String actualResult = output4.getDueDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenDailyRentalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(2.99).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output4.getDailyRentalCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenChargeDaysAssertionSucceeds() {
        Integer expectedResult = 3;
        Integer actualResult = output4.getChargeDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenPreDiscountChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(8.97).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output4.getPreDiscountCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenDiscountPercentAssertionSucceeds() {
        Integer expectedResult = 0;
        Integer actualResult = output4.getDiscountPercent();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenDiscountAmountAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output4.getDiscountAmount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test4_whenCheckoutValid_thenFinalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(8.97).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output4.getFinalCharge();
        assertEquals(expectedResult, actualResult);
    }

    // TEST 5

    @Test
    void test5_whenCheckoutValid_thenToolCodeAssertionSucceeds() {
        String expectedResult = "JAKR";
        String actualResult = output5.getTool().getToolCode();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenToolTypeAssertionSucceeds() {
        String expectedResult = "Jackhammer";
        String actualResult = output5.getTool().getToolType();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenToolBrandAssertionSucceeds() {
        String expectedResult = "Ridgid";
        String actualResult = output5.getTool().getBrand();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenRentalDaysAssertionSucceeds() {
        Integer expectedResult = 9;
        Integer actualResult = output5.getRentDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenCheckoutDateAssertionSucceeds() {
        String expectedResult = "07/02/15";
        String actualResult = output5.getCheckoutDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenDueDateAssertionSucceeds() {
        String expectedResult = "07/11/15";
        String actualResult = output5.getDueDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenDailyRentalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(2.99).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output5.getDailyRentalCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenChargeDaysAssertionSucceeds() {
        Integer expectedResult = 5;
        Integer actualResult = output5.getChargeDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenPreDiscountChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(14.95).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output5.getPreDiscountCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenDiscountPercentAssertionSucceeds() {
        Integer expectedResult = 0;
        Integer actualResult = output5.getDiscountPercent();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenDiscountAmountAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output5.getDiscountAmount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test5_whenCheckoutValid_thenFinalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(14.95).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output5.getFinalCharge();
        assertEquals(expectedResult, actualResult);
    }

    // TEST 6

    @Test
    void test6_whenCheckoutValid_thenToolCodeAssertionSucceeds() {
        String expectedResult = "JAKR";
        String actualResult = output6.getTool().getToolCode();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenToolTypeAssertionSucceeds() {
        String expectedResult = "Jackhammer";
        String actualResult = output6.getTool().getToolType();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenToolBrandAssertionSucceeds() {
        String expectedResult = "Ridgid";
        String actualResult = output6.getTool().getBrand();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenRentalDaysAssertionSucceeds() {
        Integer expectedResult = 4;
        Integer actualResult = output6.getRentDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenCheckoutDateAssertionSucceeds() {
        String expectedResult = "07/02/20";
        String actualResult = output6.getCheckoutDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenDueDateAssertionSucceeds() {
        String expectedResult = "07/06/20";
        String actualResult = output6.getDueDate();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenDailyRentalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(2.99).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output6.getDailyRentalCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenChargeDaysAssertionSucceeds() {
        Integer expectedResult = 1;
        Integer actualResult = output6.getChargeDayCount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenPreDiscountChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(2.99).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output6.getPreDiscountCharge();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenDiscountPercentAssertionSucceeds() {
        Integer expectedResult = 50;
        Integer actualResult = output6.getDiscountPercent();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenDiscountAmountAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output6.getDiscountAmount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void test6_whenCheckoutValid_thenFinalChargeAssertionSucceeds() {
        BigDecimal expectedResult = new BigDecimal(1.49).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualResult = output6.getFinalCharge();
        assertEquals(expectedResult, actualResult);
    }

}