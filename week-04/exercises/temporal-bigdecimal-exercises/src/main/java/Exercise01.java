
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Exercise01 {

    // LocalDate
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. return today's date
    LocalDate getToday() {

        return LocalDate.now();
    }

    // 2. return December 17, 1903 as a LocalDate
    LocalDate getFirstFlightDate() {

        return LocalDate.of(1903, 12, 17);
    }

    // 3. if parameter is in the future, return null.
    // Otherwise, add 5 days to the parameter and return the result.
    LocalDate makeFutureNullShiftThePast(LocalDate date) {

        if (date.isAfter(LocalDate.now())) { //if date is from the future, null.
            return null;
        } else {
            return date.plusDays(5); //else add five days, method date.plusDays.
        }
    }

    // 4. return the fifth Friday from the parameter date.
    // if the date is Friday, don't count it.
    LocalDate fiveFridaysFromDate(LocalDate date) {
        while (date.getDayOfWeek() != DayOfWeek.FRIDAY) {
            date = date.plusDays(1);
        }
        // Move ahead by 28 days to find the fifth Friday.
        return date.plusDays(28);
    }

    // 5. given a date and a count,
    // return a list of the next `fridayCount` Fridays after the date.
    // if the date is Friday, don't include it.
    List<LocalDate> getNextFridays(LocalDate date, int fridayCount) {

        ArrayList<LocalDate> fridays = new ArrayList<>();
        while (fridays.size() < fridayCount) {
            date = date.plusDays(1);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays.add(date);
            }
        }
        return fridays;
    }

    // 6. return the absolute value of the days between two dates.
    // one may be before two, two may be before one, but neither will be null
    int getDaysBetween(LocalDate one, LocalDate two) {
        return Math.abs((int) one.until(two, ChronoUnit.DAYS));
    }

}
