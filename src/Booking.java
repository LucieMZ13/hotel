import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Booking {
    private Room room;
    private boolean isVacation;
    private LocalDate reservationFrom;
    private LocalDate reservationTo;
    private List<Guest> guest;

    public Booking(Room room, boolean isVacation,
                   LocalDate reservationFrom,
                   LocalDate reservationTo, List<Guest> guest) {
        this.room = room;
        this.isVacation = isVacation;
        this.reservationFrom = reservationFrom;
        this.reservationTo = reservationTo;
        this.guest = guest;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isVacation() {
        return isVacation;
    }

    public void setVacation(boolean vacation) {
        isVacation = vacation;
    }

    public LocalDate getReservationFrom() {
        return reservationFrom;
    }

    public void setReservationFrom(LocalDate reservationFrom) {
        this.reservationFrom = reservationFrom;
    }

    public LocalDate getReservationTo() {
        return reservationTo;
    }

    public void setReservationTo(LocalDate reservationTo) {
        this.reservationTo = reservationTo;
    }

    public List<Guest> getGuests() {
        return guest;
    }

    public Guest getMainGuest() {
        return guest.getFirst();
    }

    public void setGuest(List<Guest> guest) {
        this.guest = guest;
    }
    public int getGuestsCount() {
        return guest.size();

    }
    public int getBookingLenght() {
        return reservationFrom.until(reservationTo).getDays();
    }

    public BigDecimal getTotalPrice() {
        return room.getPrice().multiply(BigDecimal.valueOf(getBookingLenght()));
    }
    public String getFormattedSummary() {
        Guest guest = getMainGuest();
        return reservationFrom+" až "+reservationTo+": "+guest.getFirstName()+
                " "+guest.getLastName()+" ("+guest.getDateOfBirth()+") "+
                " ["+getGuestsCount()+", "+(getRoom().isHasViewOfSea()?"ano":"ne")
                +"] za "+getTotalPrice()+" Kč";
    }
    public String getDescription() {
        Guest guest = getMainGuest();
        String result = "Rezervace pro: " +
                guest.getDescription() + " na pokoj: " + room.getRoomNumber() + " termín: " +
                reservationFrom + " - " + reservationTo + " pracovní pobyt "
                + (isVacation ? "ne" : "ano");
    return result;
    }
}
