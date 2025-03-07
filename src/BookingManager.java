import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList = new ArrayList<>();

    public void addBooking(Booking newBooking) {
        bookingList.add(newBooking);
    }

    public Booking get(int index) {
        return bookingList.get(index);
    }

    public List<Booking> getBookings() {
        return bookingList;
    }

    public void clearBookings() {
        bookingList.clear();
    }

    public int getNumberOfWorkingBookings() {
        int numberOfWorkingBookings = 0;
        for (Booking booking : bookingList) {
            if (!booking.isVacation()) {
                numberOfWorkingBookings++;
            }
        }
        return numberOfWorkingBookings;
    }

    public int getTotalBookings() {
        return bookingList.size();
    }

    public double getAverageGuests() {
        int totalGuests = 0;
        for (Booking booking : bookingList) {
            totalGuests += booking.getGuestsCount();
        }
        return (double) getTotalBookings() / totalGuests;
    }

    public List<Booking> getTopNHolidayBookings(int n) {
        List<Booking> vacationBookings = new ArrayList<>();
        for (int i = 0; vacationBookings.size() <= n; i++) {
            for (Booking booking : bookingList) {
                if (booking.isVacation()) {
                    vacationBookings.add(booking);
                }
            }
        }
        return vacationBookings;
    }

    public void printGuestStatistics() {
        int oneGuest = 0, twoGuests = 0, moreGuests = 0;
        for (Booking booking : bookingList) {
            switch (booking.getGuestsCount()) {
                case 1:
                    oneGuest++;
                    break;
                case 2:
                    twoGuests++;
                    break;
                default:
                    moreGuests++;
            }
        }
        System.out.println("Počet rezervací s jedním hostem: " + oneGuest);
        System.out.println("Počet rezervací se dvěma hosty: " + twoGuests);
        System.out.println("Počet rezervací s více hosty: " + moreGuests);
    }
}
