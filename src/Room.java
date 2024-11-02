import java.math.BigDecimal;

public class Room {
    private int roomNumber;
    private int beds;
    private boolean hasBalcony;
    private boolean hasViewOfSea;
    private BigDecimal price;


    public Room(int roomNumber, int beds, boolean hasBalcony,
                boolean hasViewOfSea, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.hasBalcony = hasBalcony;
        this.hasViewOfSea = hasViewOfSea;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasViewOfSea() {
        return hasViewOfSea;
    }

    public void setHasViewOfSea(boolean hasViewOfSea) {
        this.hasViewOfSea = hasViewOfSea;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}


