interface Walk {
    void walking();
}

class CanWalk implements Walk {
    @Override
    public void walking() {
        System.out.println("Can Walk");
    }
}

class CantWalk implements Walk {
    @Override
    public void walking() {
        System.out.println("Cannot Walk");
    }
}

interface Fly {
    void flying();
}

class CanFly implements Fly {
    @Override
    public void flying() {
        System.out.println("Can Fly");
    }
}

class CantFly implements Fly {
    @Override
    public void flying() {
        System.out.println("Cannot Fly");
    }
}

interface Talk {
    void talking();
}

class CanTalk implements Talk {
    @Override
    public void talking() {
        System.out.println("Can Talk");
    }
}

class CantTalk implements Talk {
    @Override
    public void talking() {
        System.out.println("Cannot Talk");
    }
}

class Robot {
    private Walk walkBehavior;
    private Fly flyBehavior;
    private Talk talkBehavior;

    public Robot(Walk walkBehavior, Fly flyBehavior, Talk talkBehavior) {
        this.walkBehavior = walkBehavior;
        this.flyBehavior = flyBehavior;
        this.talkBehavior = talkBehavior;
    }

    public void performWalk() {
        walkBehavior.walking();
    }

    public void performFly() {
        flyBehavior.flying();
    }

    public void performTalk() {
        talkBehavior.talking();
    }

    
    public void setWalkBehavior(Walk walkBehavior) {
        this.walkBehavior = walkBehavior;
    }

    public void setFlyBehavior(Fly flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setTalkBehavior(Talk talkBehavior) {
        this.talkBehavior = talkBehavior;
    }
}

public class StrategyDesignPattern {
    public static void main(String[] args) {

        Robot humanoid = new Robot(
                new CanWalk(),
                new CantFly(),
                new CanTalk()
        );
        
        humanoid.performWalk();
        humanoid.performFly();
        humanoid.performTalk();

        System.out.println("-----");

        Robot Alexa=new Robot(new CantWalk(), new CantFly(), new CanTalk());
        Alexa.performFly();
        Alexa.performTalk();
        Alexa.performWalk();
        
    }
}