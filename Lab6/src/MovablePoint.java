// Nico Rojas
// CSE 271, Lab 6
// 3.7.16

public class MovablePoint implements Movable {

	// x=left,right y=up,down
	int x, y, xSpeed, ySpeed;

	/**
	 * @param x
	 * @param y
	 * @param xSpeed
	 * @param ySpeed
	 */
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the xSpeed
	 */
	public int getxSpeed() {
		return xSpeed;
	}

	/**
	 * @param xSpeed
	 *            the xSpeed to set
	 */
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * @return the ySpeed
	 */
	public int getySpeed() {
		return ySpeed;
	}

	/**
	 * @param ySpeed
	 *            the ySpeed to set
	 */
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovablePoint [x=" + x + ", y=" + y + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "]";
	}

	// x=left,right y=up,down
	@Override
	public void moveLeft() {
		x -= xSpeed; // speed contributes to distance moved
	}

	@Override
	public void moveRight() {
		x += xSpeed;
	}

	@Override
	public void moveUp() {
		y += ySpeed;
	}

	@Override
	public void moveDown() {
		y -= ySpeed;
	}
}