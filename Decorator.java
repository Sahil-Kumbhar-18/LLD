// Component
interface Character {
    String getAbilities();
}

// Concrete Component
class Mario implements Character {
    @Override
    public String getAbilities() {
        return "Mario";
    }
}

// Abstract Decorator
abstract class CharacterDecorator implements Character {

    protected Character character;

    public CharacterDecorator(Character character) {
        this.character = character;
    }
}

// Concrete Decorator 1
class FirePower extends CharacterDecorator {

    public FirePower(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " + Fire Power";
    }
}

// Concrete Decorator 2
class SuperJump extends CharacterDecorator {

    public SuperJump(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " + Super Jump";
    }
}

// Concrete Decorator 3
class Invincible extends CharacterDecorator {

    public Invincible(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " + Invincible";
    }
}

public class Decorator {

    public static void main(String[] args) {

        Character mario = new Mario();
        System.out.println(mario.getAbilities());

        mario = new FirePower(mario);
        System.out.println(mario.getAbilities());

        mario = new SuperJump(mario);
        System.out.println(mario.getAbilities());

        mario = new Invincible(mario);
        System.out.println(mario.getAbilities());
    }
}