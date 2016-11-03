package Facade;

public class MainFacade {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}

// Facade
class Computer {
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on(){
        System.out.println("Power on");
    }
    void of(){
        System.out.println("Power of");
    }
}

class DVDRom {
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    void load(){
        data = true;
    }
    void unload(){
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd){
        if(dvd.hasData()){
            System.out.println("Copying data from dvd");
        }
        else
        {
            System.out.println("Insert dvd");
        }
    }
}