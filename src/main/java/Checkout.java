package src.main.java;

import java.math.BigDecimal;

public class Checkout {

    private Tool tool;
    private Integer rentDayCount;
    private String checkoutDate;
    private String dueDate;
    private BigDecimal dailyRentalCharge;
    private Integer chargeDayCount;
    private BigDecimal preDiscountCharge;
    private Integer discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal finalCharge;

    public Checkout() {
    }

    public Checkout(Tool tool, Integer rentDayCount, String checkoutDate, String dueDate,
                    BigDecimal dailyRentalCharge, Integer chargeDayCount, BigDecimal preDiscountCharge,
                    Integer discountPercent, BigDecimal discountAmount, BigDecimal finalCharge) {
        this.tool = tool;
        this.rentDayCount = rentDayCount;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDayCount = chargeDayCount;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Integer getRentDayCount() {
        return rentDayCount;
    }

    public void setRentDayCount(Integer rentDayCount) {
        this.rentDayCount = rentDayCount;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public void setDailyRentalCharge(BigDecimal dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public Integer getChargeDayCount() {
        return chargeDayCount;
    }

    public void setChargeDayCount(Integer chargeDayCount) {
        this.chargeDayCount = chargeDayCount;
    }

    public BigDecimal getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(BigDecimal preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(BigDecimal finalCharge) {
        this.finalCharge = finalCharge;
    }
}
