package Bridge;

public class MainBridge {

    public static void main(String[] args) {
        Device device = new NotebookDevice(new CheapHeadphones());
        device.playMusic();
    }
}

// Implementor
interface BaseHeadphones {
    void playSimpleSound();
}

// ConcreteImplementor 1
class CheapHeadphones implements BaseHeadphones{
    public void playSimpleSound() {
        System.out.println("CheapHeadphones puf-puf");
    }
}
// ConcreteImplementor 2
class ExpensiveHeadphones implements BaseHeadphones {
    public void playSimpleSound() {
        System.out.println("ExpensiveHeadphones puf-puf");
    }
}

// Abstraction
abstract class Device{
    BaseHeadphones headphones;
    Device(BaseHeadphones headphones) {this.headphones = headphones;}
    abstract void playMusic();
}

// RefinedAbstraction
class NotebookDevice extends Device {
    NotebookDevice(BaseHeadphones headphones) {
        super(headphones);
    }
    void playMusic() {
        headphones.playSimpleSound();
    }
}