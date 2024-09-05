class Engine {
    public void start() {
        System.out.println("Engine starting");
    }

    public void rev() {
        System.out.println("Engine revving");
    }

    public void stop() {
        System.out.println("Engine stopping");
    }

    // Phương thức service được thêm vào
    public void service() {
        System.out.println("Engine servicing");
    }
}

class Wheel {
    public void inflate(int psi) {
        System.out.println("Inflating wheel to " + psi + " PSI");
    }
}

class Window {
    public void rollup() {
        System.out.println("Window rolling up");
    }

    public void rolldown() {
        System.out.println("Window rolling down");
    }
}

class Door {
    public Window window = new Window();

    public void open() {
        System.out.println("Door opening");
    }

    public void close() {
        System.out.println("Door closing");
    }
}

public class Car {
	public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door left = new Door(), right = new Door(); // 2-door

    public Car() {
        for (int i = 0; i < 4; i++) {
            wheel[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
        
        // Gọi phương thức service của Engine
        car.engine.service();
    }
}
