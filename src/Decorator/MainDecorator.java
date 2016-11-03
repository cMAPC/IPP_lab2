package Decorator;

public class MainDecorator {

    public static void main(String[] args) {
        Device computer = new VideocardDecorator(new RAMDecorator(new Computer("Asus K50J")));
        computer.upgradeComponent();
    }
}


// Component
interface Device{
    void upgradeComponent();
}
// Concrete Component
class Computer implements Device{
    String model;
    public Computer(String model) {
        this.model = model;
    }
    public void upgradeComponent() {
        System.out.println(model);
    }
}

// Decorator
abstract class Decorator implements Device{
    Device device;
    public Decorator(Device device){
        this.device = device;
    }
}

// ConcreteDecorator 1
class RAMDecorator extends Decorator{
    public RAMDecorator(Device device) {
        super(device);
    }

    public void upgradeComponent() {
        System.out.print("Ram was upgraded ");
        device.upgradeComponent();
    }
}
// ConcreteDecorator 2
class VideocardDecorator extends Decorator {
    public VideocardDecorator(Device device) {
        super(device);
    }
    public void upgradeComponent() {
        System.out.print("Videcard was upgraded ");
        device.upgradeComponent();
    }
}




//// Component
//interface PrinterInterface{
//    void print();
//}
//
//// Concrete Component
//class Printer implements PrinterInterface{
//    String value;
//
//    public Printer(String value) {
//        this.value = value;
//    }
//    public  void print(){
//        System.out.print(value);
//    }
//}

//// Decorator
//abstract class Decorator implements PrinterInterface{
//    PrinterInterface component;
//    public Decorator(PrinterInterface component) {
//        this.component = component;
//    }
//}
//
//// Concrete Decorator 1
//class QuotesDecorator extends Decorator{
//
//    public QuotesDecorator(PrinterInterface component) {
//        super(component);
//    }
//    public void print(){
//        System.out.print("\"");
//        component.print();
//        System.out.print("\"");
//    }
//}
//
//// Concrete Decorator 2
//class BracketDecorator extends Decorator{
//
//    public BracketDecorator(PrinterInterface component) {
//        super(component);
//    }
//    public void print(){
//        System.out.print("[");
//        component.print();
//        System.out.print("]");
//    }
//}