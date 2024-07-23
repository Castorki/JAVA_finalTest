import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = nbList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number of wanted filter: \n");
        System.out.print(menu());
        int choice = scanner.nextInt();
        System.out.println(getMethode(notebooks, choice));
    }

    public static Set<Notebook> nbList(){
        
        Notebook nb1 = new Notebook();
        nb1.label = "Huawei";
        nb1.processor = "Intel Core i7";
        nb1.graphics = "NVIDIA GeForce RTX 3060";
        nb1.sizeMemory = 8;
        nb1.typeStorage = "SSD";
        nb1.sizeStorage = 256;
        nb1.displaySize = 14;
        nb1.os = "Linux";
        nb1.color = "Red";
        nb1.price = 12000;

        Notebook nb2 = new Notebook();
        nb2.label = "ASUS";
        nb2.processor = "AMD Ryzen 5";
        nb2.graphics = "AMD Radeon RX 5600M";
        nb2.sizeMemory = 15;
        nb2.typeStorage = "HHD";
        nb2.sizeStorage = 326;
        nb2.displaySize = 16;
        nb2.os = "windows";
        nb2.color = "Black";
        nb1.price = 15000;

        Notebook nb3 = new Notebook();
        nb3.label = "HONOR";
        nb3.processor = "Intel Core i3";
        nb3.graphics = "NVIDIA GeForce RTX 4090";
        nb3.sizeMemory = 4;
        nb3.typeStorage = "SSD";
        nb3.sizeStorage = 256;
        nb3.displaySize = 15;
        nb3.os = "windows";
        nb3.color = "Blue";
        nb1.price = 14000;

        Notebook nb4 = new Notebook();
        nb4.label = "Lenovo";
        nb4.processor = "Intel Core i7";
        nb4.graphics = "NVIDIA GeForce RTX 3060";
        nb4.sizeMemory = 8;
        nb4.typeStorage = "SSD";
        nb4.sizeStorage = 256;
        nb4.displaySize = 14;
        nb4.os = "Linux";
        nb4.color = "Red";
        nb1.price = 21000;

        Notebook nb5 = new Notebook();
        nb5.label = "Huawei";
        nb5.processor = "Intel Core i7";
        nb5.graphics = "NVIDIA GeForce RTX 3090";
        nb5.sizeMemory = 12;
        nb5.typeStorage = "SSD";
        nb5.sizeStorage = 516;
        nb5.displaySize = 18;
        nb5.os = "Mac";
        nb5.color = "Red";
        nb5.price = 8000;
        
        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(nb1, nb2, nb3, nb4, nb5));
        return notebooks;
    }

    public static Set<Notebook> printNotebookSet(Set <Notebook> notes) {
        notes.forEach(notebook -> System.out.println(notebook + "\n"));
        return moveOn(notes);
    }

    public static String menu() {
        return "1. Filter by label\n" +
               "2. Filter by processor\n" +
               "3. Filter by graphics\n" +
               "4. Filter by size of memory\n" +
               "5. Filter by type of storage\n" +
               "6. Filter by size of storage\n" +
               "7. Filter by display size\n" +
               "8. Filter by operating system\n" +
               "9. Filter by color\n" +
               "10. Filter by price\n";
    }

    public static Set<Notebook> moveOn(Set <Notebook> notes){
        System.out.print("Do you want to continue? (yes/no): ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("yes")) {
            System.out.print("Enter a number of wanted filter: \n");
            System.out.print(menu());
            int choice = scanner.nextInt();
            return getMethode(notes, choice);
        }
        return null;
    }

    public static Set<Notebook> getMethode(Set<Notebook> notebooks, int choice) {
        Set<Notebook> result = new HashSet<>();
        if(choice == 1) {
            System.out.print("Enter a label: ");
            Scanner scanner = new Scanner(System.in);
            String label = scanner.nextLine();
            result = filterByLabel(notebooks, label);
        }
        else if (choice == 2){
            System.out.print("Enter a processor: ");
            Scanner scanner = new Scanner(System.in);
            String processor = scanner.nextLine();
            result = filterByProcessor(notebooks, processor);
        }
        else if (choice == 3){
            System.out.print("Enter a graphics: ");
            Scanner scanner = new Scanner(System.in);
            String graphics = scanner.nextLine();
            result = filterByGraphics(notebooks, graphics);
        }    
        else if (choice == 4){
            System.out.print("Enter a Size of memory: ");
            Scanner scanner = new Scanner(System.in);
            int sizeMemory = scanner.nextInt();
            result = filterBySizeOfMemory(notebooks, sizeMemory);
        }  
        else if (choice == 5){
            System.out.print("Enter a type of storage: ");
            Scanner scanner = new Scanner(System.in);
            String typeStorage = scanner.nextLine();
            result = filterByTypeOfStorage(notebooks, typeStorage);
        }
        else if (choice == 6){
            System.out.print("Enter a size of storage: ");
            Scanner scanner = new Scanner(System.in);
            int sizeStorage = scanner.nextInt();
            result = filterBySizeOfStorage(notebooks, sizeStorage);
        }    
        else if (choice == 7){
            System.out.print("Enter a display size: ");
            Scanner scanner = new Scanner(System.in);
            int displaySize = scanner.nextInt();
            result = filterByDisplaySize(notebooks, displaySize);
        }  
        else if (choice == 8){
            System.out.print("Enter an operating system: ");
            Scanner scanner = new Scanner(System.in);
            String os = scanner.nextLine();
            result = filterByOperatingSystem(notebooks, os);  
        }
        else if (choice == 9){
            System.out.print("Enter a Color: ");
            Scanner scanner = new Scanner(System.in);
            String color = scanner.nextLine();
            result = filterByColor(notebooks, color);  
        }
        else if (choice == 10){
            System.out.print("Enter a price: ");
            Scanner scanner = new Scanner(System.in);
            int price = scanner.nextInt();
            result = filterByPrice(notebooks, price);
        }  
        return result;
    }

    public static Set<Notebook> filterByLabel(Set<Notebook> notebooks, String label) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.label.equalsIgnoreCase(label)) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("Label not founded");
            return null;
        }
        return printNotebookSet(notes);
    }    

    public static Set<Notebook> filterByProcessor(Set<Notebook> notebooks, String processor) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.processor.equalsIgnoreCase(processor)) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("Processor not founded");
            return null;
        }
        return printNotebookSet(notes);
    }   

    public static Set<Notebook> filterByGraphics(Set<Notebook> notebooks, String graphics) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.graphics.equalsIgnoreCase(graphics)) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("Not founded");
            return null;
        }
        return printNotebookSet(notes);
    }   

    public static Set<Notebook> filterBySizeOfMemory(Set<Notebook> notebooks, int sizeMemory) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.sizeMemory == sizeMemory) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("Size of memory not founded");
            return null;
        }
        return printNotebookSet(notes);
    }    

    public static Set<Notebook> filterByTypeOfStorage(Set<Notebook> notebooks, String typeStorage) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.typeStorage.equalsIgnoreCase(typeStorage)) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("Type of storage not founded");
            return null;
        }
        return printNotebookSet(notes);
    }   

    public static Set<Notebook> filterBySizeOfStorage(Set<Notebook> notebooks, int sizeStorage) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.sizeStorage == sizeStorage) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("Size of storage not founded");
            return null;
        }
        return printNotebookSet(notes);
    }   

    public static Set<Notebook> filterByDisplaySize(Set<Notebook> notebooks, int displaySize) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.displaySize == displaySize) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("Display Size not founded");
            return null;
        }
        return printNotebookSet(notes);
    }   

    public static Set<Notebook> filterByOperatingSystem(Set<Notebook> notebooks, String os) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.os.equalsIgnoreCase(os)) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("OS not founded");
            return null;
        }
        return printNotebookSet(notes);
    }   


    public static Set<Notebook> filterByColor(Set<Notebook> notebooks, String color) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.color.equalsIgnoreCase(color)) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("Color not founded");
            return null;
        }
        return printNotebookSet(notes);
    }   

    public static Set<Notebook> filterByPrice(Set<Notebook> notebooks, int price) {
        Set <Notebook> notes = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.price == price) {
                notes.add(notebook);
            }
        }
        if (notes.isEmpty()){
            System.out.println("Notebook whith this price is not found");
            return null;
        }
        return printNotebookSet(notes);
    } 



  


    

}

