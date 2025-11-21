package nov21;
public class Abstraction {
    public static void main(String[] args) {
        // Using Abstract Class
        Game g2 = new Football();
        g2.cricket();
        g2.football();
        g2.hockey();
        g2.run();
        // Using Interfaces
        Game1 race = new CarRace();
        Game2 race2 = new CarRace();
        race.start();
        race.stop();
        race2.shoot();
        race2.run();
    }
}
// a) Using Abstract Class
abstract class Game {
    abstract void cricket();
    abstract void football();
    abstract void hockey();
    void run() {
        System.out.println("Player is running on the field...");
    }
}
class Cricket extends Game {
    void cricket() {
        System.out.println("Playing Cricket - Batting & Bowling!");
    }
    void football() {}
    void hockey() {}
}
class Football extends Cricket {
    void football() {
        System.out.println("Playing Football - Goal!!!");
    }
}
// b) Using Interfaces
interface Game1 {
    void start();
    void stop();
}
interface Game2 {
    void shoot();
    void run();
}
class CarRace implements Game1, Game2 {
    public void start() {
        System.out.println("Race is starting! Ready... Set... Go!");
    }
    public void stop() {
        System.out.println("Race has stopped!");
    }
    public void shoot() {
        System.out.println("Boost activated!");
    }
    public void run() {
        System.out.println("Speeding through the track!");
    }
}
