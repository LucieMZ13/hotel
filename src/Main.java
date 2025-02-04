import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookingManager manager = new BookingManager();
        fillBookings(manager);
        testCode(manager);
        }
        private static void fillBookings (BookingManager manager) {
        Guest karel1 = new Guest("Karel","Dvořák",
                LocalDate.of(1990,5,15));
        Guest karel2 = new Guest("Karel","Dvořák",
                LocalDate.of(1979,1,3));
        Guest karolina1 = new Guest("Karolína","Tmavá",
                LocalDate.of(1989,12,12));
        Room room1 = new Room(1,1,true,true,
                BigDecimal.valueOf(1000));
        Room room2 = new Room(2,1,true,true,
                BigDecimal.valueOf(1000));
        Room room3 = new Room(3,3,false,true,
                BigDecimal.valueOf(2400));

        List<Guest> karel1List = new ArrayList<>();
        karel1List.add(karel1);
            manager.addBooking(new Booking(room3,false,LocalDate.of(2023,6,1),
                LocalDate.of(2023,6,7),karel1List));
        List<Guest> karel2List = new ArrayList<>();
        karel2List.add(karel2);
            manager.addBooking(new Booking(room2,true,LocalDate.of(2023,7,18),
                    LocalDate.of(2023,7,21),karel2List));
        List<Guest> karolina1karel1List = new ArrayList<>();
        karolina1karel1List.add(karolina1);
        karolina1karel1List.add(karel1);
            manager.addBooking(new Booking(room3,false,LocalDate.of(2023,8,1),
                    LocalDate.of(2023,8,31),karolina1karel1List));
        List<Guest> karolina1List = new ArrayList<>();
        karolina1List.add(karolina1);

            for (int i = 1; i < 20; i += 2) {
                manager.addBooking(new Booking(room2,true,
                        LocalDate.of(2023,8,(i)),
                        LocalDate.of(2023,8,(i+1)),karolina1List));
            }
        }
        private static void testCode(BookingManager manager) {
            System.out.println("Počet pracovních pobytů: "+manager.getNumberOfWorkingBookings());
            System.out.println("\nPrůměrný počet hostů na rezervaci: "+
                    manager.getAverageGuests());
            System.out.println("\nPrvních osm rekreačních rezervací: ");
                    manager.getTopNHolidayBookings(8).forEach(booking -> System.out.println(booking.getDescription()));
            System.out.println("Statistiky hostů: ");
                    manager.printGuestStatistics();
            System.out.println("Formátovaný výpis všech rezervací v systému: ");
            for (Booking booking : manager.getBookings()) {
                System.out.println(booking.getFormattedSummary());
            }
        }
    }



