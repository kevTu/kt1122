package src.main.java;

public enum CheckoutEnum {
    TOOL_CODE, TOOL_TYPE, TOOL_BRAND, RENTAL_DAYS, CHECK_OUT_DATE, DUE_DATE, DAILY_RENTAL_CHARGE, CHARGE_DAYS,
    PRE_DISCOUNT_CHARGE, DISCOUNT_PERCENT, DISCOUNT_AMOUNT, FINAL_CHARGE;

    @Override
    public String toString() {
        switch(this) {
            case TOOL_CODE:
                return "Tool code";
            case TOOL_TYPE:
                return "Tool type";
            case TOOL_BRAND:
                return "Tool brand";
            case RENTAL_DAYS:
                return "Rental days";
            case CHECK_OUT_DATE:
                return "Check out date";
            case DUE_DATE:
                return "Due date";
            case DAILY_RENTAL_CHARGE:
                return "Daily rental charge";
            case CHARGE_DAYS:
                return "Charge days";
            case PRE_DISCOUNT_CHARGE:
                return "Pre-discount charge";
            case DISCOUNT_PERCENT:
                return "Discount percent";
            case DISCOUNT_AMOUNT:
                return "Discount amount";
            case FINAL_CHARGE:
                return "Final charge";
            default:
                return "";
        }
    }
}
