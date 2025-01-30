import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guest guest1 = new Guest("Adéla", "Malíková",
                LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest("Jan", "Dvořáček",
                LocalDate.of(1995, 5, 5));
        guest2.setDateOfBirth(LocalDate.of(1995, 4, 5));
        System.out.println(guest2.getDescription());
        List<Guest> guestsList = new ArrayList<>();
        guestsList.add(guest1);
        guestsList.add(guest2);

        Room room1 = new Room(1, 1, true,
                true, BigDecimal.valueOf(1000));
        Room room2 = new Room(2, 1, true,
                true, BigDecimal.valueOf(1000));
        Room room3 = new Room(3, 3, false,
                true, BigDecimal.valueOf(2400));

        Booking booking1 = new Booking(room1, true,
                LocalDate.of(2021, 7, 19),
                LocalDate.of(2021, 7, 26),List.of(guest1));
        Booking booking2 = new Booking(room3, true,
                LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 9, 14),
                List.of(guest1,guest2));

        List<Booking> bookingsList = new ArrayList<>();
        bookingsList.add(booking1);
        bookingsList.add(booking2);

        for (Booking bookingPrint : bookingsList) {
            System.out.println("Host " + bookingPrint.getMainGuest().getDescription() +
                    " má rezervován pokoj " + bookingPrint.getRoom().getRoomNumber() +
                    " od " + bookingPrint.getReservationFrom() +
                    " do " + bookingPrint.getReservationTo() +
                     ".");
        }

        }
        }

