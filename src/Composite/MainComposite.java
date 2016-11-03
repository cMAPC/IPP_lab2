package Composite;

import java.util.ArrayList;
import java.util.List;

public class MainComposite {

    public static void main(String[] args) {
        ComputerComponent motherboard = new Motherboard();
        ComputerComponent videocard = new Videocard();

        Composite composite = new Composite();
        composite.addComponent(motherboard);
        composite.addComponent(videocard);
//        composite.removeComponent(videocard);
        composite.insertComponent();
    }
}


// Component
interface ComputerComponent {
    void insertComponent();
}

// Node 1
class Motherboard implements ComputerComponent{
    public void insertComponent() {
        System.out.println("Motherboard was inserted");
    }
}

// Node 2
class Videocard implements ComputerComponent{
    public void insertComponent() {
        System.out.println("Videocard was inserted");
    }
}

// Composite
class Composite implements ComputerComponent {
    private List<ComputerComponent> components = new ArrayList<>();
    public void addComponent(ComputerComponent component) {
        components.add(component);
    }
    public void removeComponent(ComputerComponent component) {
        components.remove(component);
    }

    public void insertComponent() {
        for(ComputerComponent component: components)
            component.insertComponent();
    }
}