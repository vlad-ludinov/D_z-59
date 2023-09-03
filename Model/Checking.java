package model;
import java.time.LocalDate;

import exception.InvalidDataFormatException;

public class Checking {
    
    public static boolean isInt(String str) {
        try {
            Integer integer = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDay(String strDay, Integer countDay) {
        Integer intDay = Integer.parseInt(strDay);
        if (intDay > 0 && intDay < countDay + 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMonth(String strMonth) {
        Integer intMonth = Integer.parseInt(strMonth);
        if (intMonth > 0 && intMonth < 13) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isYear(String strYear) {
        Integer intYear = Integer.parseInt(strYear);
        Integer currentYear = LocalDate.now().getYear();
        if (intYear > 0 && intYear < currentYear + 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDate(String day, String month, String year) {
        if (day.length() == 2 && month.length() == 2 && year.length() == 4
            && isInt(day) && isInt(month) && isInt(year)
            && isYear(year) && isMonth(month)) {
                boolean leapYear = false;
                if (Integer.parseInt(year) % 4 == 0) {
                    leapYear = true;
                }
                Integer integerMonth = Integer.parseInt(month);
                if (isDay(day, countDayMonth(integerMonth, leapYear))) {
                    return true;
                } else {
                    return false;
                }
        } else {
            return false;
        }
    }

    public static Integer countDayMonth(Integer month, boolean leapYear) {
        if (month == 1 || month == 3 || month == 5 || month == 7
            || month == 8 || month == 10 || month == 12) {
                return 31;
        } else {
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                return 30;
            } else {
                if (leapYear) {
                    return 29;
                } else {
                    return 28;
                }
            }
        }
    }

    public static boolean isPhoneNumber(String phone) {
        try {
            Long phoneNumber = Long.parseLong(phone);
            if (phone.length() == 11 && phoneNumber < 100000000000L && phoneNumber > 9999999999L) {
                return true;
            } else {
                throw new InvalidDataFormatException();
            }
        } catch (NumberFormatException | InvalidDataFormatException e) {
            return false;
        }
    }

    public static boolean isGender(String gender) {
        if (gender.length() == 1 && (gender.charAt(0) == 'f' || gender.charAt(0) == 'm')) {
            return true;
        } else {
            return false;
        }
    }
}
