package Ex14;

import Ex5.C;

public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door left = new Door(), right = new Door();

    public Car(){
        for(int i = 0; i < 4; i++){
            wheel[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rolldown();
        car.wheel[0].inflate(74);
        car.engine.service();
    }
}
