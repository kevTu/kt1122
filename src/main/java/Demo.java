package src.main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        try {
            runProcess();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void runProcess() throws Exception {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter tool code:");
            String toolCode = sc.nextLine();
            System.out.println("Enter rental days (value must be greater than 0):");
            Integer rentDayCount = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter discount percent (value must be between 0 and 100):");
            Integer discountPercent = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter check out date (format mm/dd/yy):");
            String checkoutDate = sc.nextLine();
            Checkout output = generateOutput(toolCode, checkoutDate, rentDayCount, discountPercent);
            displayToConsole(output);
        } while (true);
    }

    public static Checkout generateOutput(String toolCode, String checkoutDate, Integer rentDayCount, Integer discountPercent) throws Exception {
        if (rentDayCount < 1) throw new Exception("Invalid number of rental days. Please enter a rental day count greater than 0.");
        if (!(discountPercent >= 0 && discountPercent <= 100)) throw new Exception("Invalid discount percent. Please enter a discount percent in the range of 0 to 100.");
        int chargeDayCount = 0;
        String dueDate;
        BigDecimal preDiscountcharge;
        BigDecimal discountAmount;
        LocalDate date;
        Tool tool = Tool.findByCode(toolCode);
        if (tool == null) return null;
        Checkout checkout = new Checkout();
        checkout.setTool(tool);
        checkout.setRentDayCount(rentDayCount);
        checkoutDate = formatStrDate(checkoutDate);
        if (checkoutDate == null) return null;
        checkout.setCheckoutDate(checkoutDate);
        date = LocalDate.parse(checkoutDate, DateTimeFormatter.ofPattern("MM/dd/yy"));
        dueDate = date.plusDays(Long.valueOf(rentDayCount)).format(DateTimeFormatter.ofPattern("MM/dd/yy"));
        checkout.setDueDate(dueDate);
        checkout.setDailyRentalCharge(tool.getDailyRentalCharge());
        for (int n = 0; n < rentDayCount; n++) {
            date = date.plusDays(1);
            if (isChargeableDate(date, tool)) {
                chargeDayCount++;
            }
        }
        checkout.setChargeDayCount(chargeDayCount);
        preDiscountcharge = tool.getDailyRentalCharge().multiply(BigDecimal.valueOf(chargeDayCount)).setScale(2, RoundingMode.HALF_UP);
        checkout.setPreDiscountCharge(preDiscountcharge);
        checkout.setDiscountPercent(discountPercent);
        BigDecimal actualDiscountPercent = BigDecimal.valueOf(discountPercent).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        discountAmount = preDiscountcharge.multiply(actualDiscountPercent).setScale(2, RoundingMode.HALF_UP);
        checkout.setDiscountAmount(discountAmount);
        checkout.setFinalCharge(preDiscountcharge.subtract(discountAmount));
        return checkout;
    }

    private static boolean isChargeableDate(LocalDate date, Tool tool) {
        DayOfWeek currentDayofWeek = date.getDayOfWeek();
        if (isHolidayObserved(date)) {
            return tool.getHolidayCharged();
        }
        if (currentDayofWeek == DayOfWeek.MONDAY && tool.getWeekdayCharged()) {
            return true;
        } else if (currentDayofWeek == DayOfWeek.TUESDAY && tool.getWeekdayCharged()) {
            return true;
        } else if (currentDayofWeek == DayOfWeek.WEDNESDAY && tool.getWeekdayCharged()) {
            return true;
        } else if (currentDayofWeek == DayOfWeek.THURSDAY && tool.getWeekdayCharged()) {
            return true;
        } else if (currentDayofWeek == DayOfWeek.FRIDAY && tool.getWeekdayCharged()) {
            return true;
        } else if (currentDayofWeek == DayOfWeek.SATURDAY && tool.getWeekendCharged()) {
            return true;
        } else if (currentDayofWeek == DayOfWeek.SUNDAY && tool.getWeekendCharged()) {
            return true;
        }
        return false;
    }

    private static boolean isHolidayObserved(LocalDate date) {
        return isIndependenceDayObserved(date) || isLaborDayObserved(date);
    }

    private static boolean isIndependenceDayObserved(LocalDate date) {
        int currentYear = date.getYear();
        LocalDate independenceDayDate = LocalDate.parse(currentYear + "-" + "07" + "-" + "04");
        switch(independenceDayDate.getDayOfWeek()) {
            case SATURDAY:
                return date.equals(LocalDate.parse(currentYear + "-" + "07" + "-" + "03"));
            case SUNDAY:
                return date.equals(LocalDate.parse(currentYear + "-" + "07" + "-" + "05"));
            default:
                return date.equals(independenceDayDate);
        }
    }

    private static boolean isLaborDayObserved(LocalDate date) {
        Month currentMonth = date.getMonth();
        DayOfWeek currentDayOfWeek = date.getDayOfWeek();
        int currentDayOfMonth = date.getDayOfMonth();
        if (currentMonth == Month.SEPTEMBER && currentDayOfWeek == DayOfWeek.MONDAY) {
            if (currentDayOfMonth < 8) return true;
        }
        return false;
    }

    private static String formatStrDate(String dateStr) {
        if (dateStr == null) return null;
        StringBuilder sb = new StringBuilder();
        String[] dateParts = dateStr.split("/");
        if (dateParts.length != 3) return null;
        String month = dateParts[0];
        String day = dateParts[1];
        String year = dateParts[2];
        if (month.length() > 2 || month.length() < 1 || day.length() > 2 || day.length() < 1 || year.length() != 2) return null;
        if (month.length() == 1) {
            sb.append("0").append(month);
        } else {
            sb.append(month);
        }
        sb.append("/");
        if (day.length() == 1) {
            sb.append("0").append(day);
        } else {
            sb.append(day);
        }
        sb.append("/");
        sb.append(year);
        return sb.toString();
    }

    private static void displayToConsole(Checkout checkout) {
        if (checkout == null) {
            System.out.println("Failed to checkout. Please verify that inputs are correct.");
        } else {
            DecimalFormat dfWholeNum = new DecimalFormat("#,###");
            DecimalFormat dfDollars = new DecimalFormat("#,##0.00");
            System.out.println(CheckoutEnum.TOOL_CODE + ": " + checkout.getTool().getToolCode());
            System.out.println(CheckoutEnum.TOOL_TYPE + ": " + checkout.getTool().getToolType());
            System.out.println(CheckoutEnum.TOOL_BRAND + ": " + checkout.getTool().getBrand());
            System.out.println(CheckoutEnum.RENTAL_DAYS + ": " + dfWholeNum.format(checkout.getRentDayCount()));
            System.out.println(CheckoutEnum.CHECK_OUT_DATE + ": " + checkout.getCheckoutDate());
            System.out.println(CheckoutEnum.DUE_DATE + ": " + checkout.getDueDate());
            System.out.println(CheckoutEnum.DAILY_RENTAL_CHARGE + ": " + "$" + dfDollars.format(checkout.getDailyRentalCharge()));
            System.out.println(CheckoutEnum.CHARGE_DAYS + ": " + dfWholeNum.format(checkout.getChargeDayCount()));
            System.out.println(CheckoutEnum.PRE_DISCOUNT_CHARGE + ": " + "$" + dfDollars.format(checkout.getPreDiscountCharge()));
            System.out.println(CheckoutEnum.DISCOUNT_PERCENT + ": " + checkout.getDiscountPercent() + "%");
            System.out.println(CheckoutEnum.DISCOUNT_AMOUNT + ": " + "$" + dfDollars.format(checkout.getDiscountAmount()));
            System.out.println(CheckoutEnum.FINAL_CHARGE + ": " + "$" + dfDollars.format(checkout.getFinalCharge()));
            System.out.println("---------------------------------------");
        }
    }
}
