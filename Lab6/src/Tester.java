// Nico Rojas
// CSE 271, Lab 6
// 3.7.16

public class Tester {

	public static void main(String[] args) {

		Movable m1 = new MovablePoint(5, 6, 10, 12); // upcast
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		Movable m2 = new MovableCircle(2, 1, 2, 20, 50); // upcast. Constructor
															// takes in 4 point
															// values and
		// radius
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);

		// chaChaSlide
		Movable[] slide = new Movable[3];
		slide[0] = new MovablePoint(3, 5, 1, 5);
		slide[1] = new MovableCircle(11, 1, 3, 18, 44);
		slide[2] = new MovableCircle(2, 2, 4, 16, 60);

		chaChaSlide(slide);
	}

	public static void chaChaSlide(Movable[] slide) {

		// Move left
		slide[0].moveLeft();
		slide[1].moveLeft();
		slide[2].moveLeft();

		// Move right
		slide[0].moveRight();
		slide[1].moveRight();
		slide[2].moveRight();

		// Move down
		slide[0].moveDown();
		slide[1].moveDown();
		slide[2].moveDown();

		// Move up
		slide[0].moveUp();
		slide[1].moveUp();
		slide[2].moveUp();

		// Move left
		slide[0].moveLeft();
		slide[1].moveLeft();
		slide[2].moveLeft();

		// Move down
		slide[0].moveDown();
		slide[1].moveDown();
		slide[2].moveDown();

		// Move up
		slide[0].moveUp();
		slide[1].moveUp();
		slide[2].moveUp();

		// Move right
		slide[0].moveRight();
		slide[1].moveRight();
		slide[2].moveRight();

		// Move left
		slide[0].moveLeft();
		slide[1].moveLeft();
		slide[2].moveLeft();

		// Move down
		slide[0].moveDown();
		slide[1].moveDown();
		slide[2].moveDown();

		// Move up
		slide[0].moveUp();
		slide[1].moveUp();
		slide[2].moveUp();

		// Move up
		slide[0].moveUp();
		slide[1].moveUp();
		slide[2].moveUp();

		// Output chaChaSlide
		System.out.println("\nCha-Cha Slide (After moves)\n" + slide[0] + "\n" + slide[1] + "\n" + slide[2]);
	}
}