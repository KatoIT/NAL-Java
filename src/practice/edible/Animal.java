package practice.edible;

public abstract class Animal implements Edible {
    public abstract String makeSound();

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
