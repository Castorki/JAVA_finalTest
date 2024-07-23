import java.util.Objects;

public class Notebook {
    String label;
    String processor;
    String graphics;
    int sizeMemory;
    String typeStorage;
    int sizeStorage;
    int displaySize;
    String os;
    String color;
    int price;

    //
    @Override
    public String toString() {
        return String.format(
                "label: %s, processor: %s, graphics: %s, sizeMemory: %d,typeStorage: %s, sizeStorage: %d, displaySize: %d, os: %s, color: %s,  price: %d, ",
                label, processor, graphics, sizeMemory, typeStorage, sizeStorage, displaySize, os, color, price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, processor, graphics, sizeMemory, typeStorage, sizeStorage, displaySize, os, color, price);
    }

}