package src.main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Tool {
    CHAINSAW("CHNS", "Chainsaw", "Stihl", new BigDecimal(1.49).setScale(2, RoundingMode.HALF_UP), true, false, true),
    JACKHAMMER_D("JAKD", "Jackhammer", "DeWalt", new BigDecimal(2.99).setScale(2, RoundingMode.HALF_UP), true, false, false),
    JACKHAMMER_R("JAKR", "Jackhammer", "Ridgid", new BigDecimal(2.99).setScale(2, RoundingMode.HALF_UP), true, false, false),
    LADDER("LADW", "Ladder", "Werner", new BigDecimal(1.99).setScale(2, RoundingMode.HALF_UP), true, true, false);

    private String toolCode;
    private String toolType;
    private String brand;
    private BigDecimal dailyRentalCharge;
    private Boolean weekdayCharged;
    private Boolean weekendCharged;
    private Boolean holidayCharged;

    Tool(String toolCode, String toolType, String brand, BigDecimal dailyRentalCharge, Boolean weekdayCharged, Boolean weekendCharged, Boolean holidayCharged) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
        this.dailyRentalCharge = dailyRentalCharge;
        this.weekdayCharged = weekdayCharged;
        this.weekendCharged = weekendCharged;
        this.holidayCharged = holidayCharged;
    }

    public static Tool findByCode(String toolCode) {
        if (toolCode != null) {
            for (Tool t : Tool.values()) {
                if (toolCode.equals(t.getToolCode())) {
                    return t;
                }
            }
        }
        return null;
    }

    public String getToolCode() {
        return toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public Boolean getWeekdayCharged() {
        return weekdayCharged;
    }

    public Boolean getWeekendCharged() {
        return weekendCharged;
    }

    public Boolean getHolidayCharged() {
        return holidayCharged;
    }
}
