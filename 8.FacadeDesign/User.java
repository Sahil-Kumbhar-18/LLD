class PowerSupply {
    public void providePower() {
        System.out.println("Power Supply Provided");
    }
}

class CPU {
    public void initializeCPU() {
        System.out.println("CPU Started");
    }
}

class BIOS {
    public void initializeBIOS() {
        System.out.println("BIOS Initialized");
    }
}

class Memory {
    public void allocate() {
        System.out.println("Memory Allocated");
    }
}

class OS {
    public void initializeOS() {
        System.out.println("Operating System Started");
    }
}

class CoolingSystem {
    public void startCooling() {
        System.out.println("Cooling System Started");
    }
}

// Facade Class
class ComputerFacade {

    private PowerSupply powerSupply;
    private CPU cpu;
    private BIOS bios;
    private Memory memory;
    private OS os;
    private CoolingSystem coolingSystem;

    public ComputerFacade() {
        powerSupply = new PowerSupply();
        cpu = new CPU();
        bios = new BIOS();
        memory = new Memory();
        os = new OS();
        coolingSystem = new CoolingSystem();
    }

    public void startComputer() {
        System.out.println("===== Starting Computer =====");

        powerSupply.providePower();
        bios.initializeBIOS();
        cpu.initializeCPU();
        memory.allocate();
        os.initializeOS();
        coolingSystem.startCooling();

        System.out.println("Computer Started Successfully");
    }
}

public class User {
    public static void main(String[] args) {

        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}