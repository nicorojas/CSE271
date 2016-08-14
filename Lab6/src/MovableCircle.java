// Nico Rojas
// CSE 271, Lab 6
// 3.7.16

public class MovableCircle implements Movable {

	private int radius;
	private MovablePoint center;

	/**
	 * @param radius
	 * @param center
	 */
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		this.radius = radius;
		this.center = new MovablePoint(x, y, xSpeed, ySpeed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovableCircle [radius=" + radius + ", center=" + center + "]";
	}

	@Override
	public void moveLeft() {
		center.x -= center.xSpeed;
	}

	@Override
	public void moveRight() {
		center.x += center.xSpeed;
	}

	@Override
	public void moveUp() {
		center.y += center.ySpeed;
	}

	@Override
	public void moveDown() {
		center.y -= center.ySpeed;
	}
}