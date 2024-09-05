package client;

import acccess.Widget;

public class TestWidget {
	public static void main(String[] args) {
		Widget widget = new Widget("MyWidget");
		
		System.out.println(widget);
		widget.setName("Nguyen");
		System.out.println(widget);
	}
}
