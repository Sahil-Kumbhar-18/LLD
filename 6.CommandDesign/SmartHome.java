interface Remote{
    public void TurnOn();
    public void TurnOff();
}
class FanCommand implements Remote{
    Fan f;
    FanCommand(Fan f){
        this.f=f;
    }
    @Override
    public void TurnOn() {
       f.On();
    }
    @Override
    public void TurnOff() {
        f.off();
    }
    
}
class Fan{
    public void On(){
        System.out.println("Fan on");
    }
    public void off(){
        System.out.println("Fan off");
    }
}

class LightCommand implements Remote{
    Light f;
    LightCommand(Light f){
        this.f=f;
    }
    @Override
    public void TurnOn() {
       f.On();
    }
    @Override
    public void TurnOff() {
        f.off();
    }
    
}
class Light{
    public void On(){
        System.out.println("Light on");
    }
    public void off(){
        System.out.println("Light off");
    }
}
class RemoteControl {

    private Remote command;

    public void setCommand(Remote command) {
        this.command = command;
    }

    public void pressOnButton() {
        command.TurnOn();
    }

    public void pressOffButton() {
        command.TurnOff();
    }
}
public class SmartHome{
    public static void main(String[] args) {
        Fan fan = new Fan();
        Light light = new Light();

        Remote fanCommand = new FanCommand(fan);
        Remote lightCommand = new LightCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(fanCommand);
        remote.pressOnButton();
        remote.pressOffButton();

        System.out.println();

        remote.setCommand(lightCommand);
        remote.pressOnButton();
        remote.pressOffButton();
    }
}