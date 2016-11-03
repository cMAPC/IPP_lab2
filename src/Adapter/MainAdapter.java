package Adapter;

public class MainAdapter {

    public static void main(String[] args) {
        SATAInterface sataInterface = new AdapterFromIDEtoSATA();
        sataInterface.insertDVD();
        sataInterface.insertHDD();
    }
}

// Target
interface SATAInterface {
    void insertDVD();
    void insertHDD();
}

// Adapteee
class IDEInterface {
    void insertIDEInterfaceDVD(){
        System.out.println("IDE DVD adapts to SATA");
    }
    void insertIDEInterfaceHDD(){
        System.out.println("IDE HDD adapts to SATA");
    }
}

// Metoda mostenirii (Adapter)

class AdapterFromIDEtoSATA extends IDEInterface implements SATAInterface {
    public void insertDVD() {
        insertIDEInterfaceDVD();
    }
    public void insertHDD() {
        insertIDEInterfaceHDD();
    }
}

// Metoda compozitiei (Adapter)

class Adapter1 implements SATAInterface{
    private IDEInterface ideInterface = new IDEInterface();
    public void insertDVD() {
        ideInterface.insertIDEInterfaceDVD();
    }
    public void insertHDD() {
        ideInterface.insertIDEInterfaceHDD();
    }
}