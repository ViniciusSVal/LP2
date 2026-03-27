public class RectAPP {
	public static void main (String[] args) {
		Rect r1 = new Rect(0, 0, 10, 10);
		r1.print();
		
		System.out.println("Movendo + (5, 5)");
		r1.drag(5, 5);
		
		r1.print();
		
		System.out.println("Movendo + (-10, 100)");
		r1.drag(-10, 100);
		
		r1.print();
    }
}

class Rect {
	int x, y; // pos
	int w, h; // dim

	Rect (int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	int area () {
		return this.w * this.h;
	}

	void drag (int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	void print () {
		System.out.printf("Retangulo de dimensoes W = %d e H = %d com area %d na posiçao (%d, %d)\n", 
			this.w, this.h, this.area(), this.x, this.y);
	}
}
