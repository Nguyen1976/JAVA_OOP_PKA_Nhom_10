class Game {
	Game(int i) {
		System.out.println("Game constructor" + i);
	}
}

class BoardGame extends Game {
	BoardGame(int i) {
		super(i);//Gọi constructor của lớp cha với đối số i và phải đặt ở đầu
		System.out.println("BoardGame constructor" + i);
	}
}

public class Chess extends BoardGame {
	Chess() {
		super(11);
		System.out.println("Chess constructor");
	}
	
	public static void main(String[] args) {
		Chess x = new Chess();
	}
}
