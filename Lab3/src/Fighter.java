/**
 * @author Nico Rojas, rojasnm
 * CSE 271, Lab 3
 * 2.12.16 RPG Fighter class.
 */

public class Fighter {

	private String name = "Rocky";
	private String trashTalk = "You're going down!";
	private String[] inventory = new String[20]; // fighter can carry 20 items
													// at a time
	private String shirt = "green", pants = "blue";

	private boolean petting;
	private boolean running;

	private int speed = (int) (Math.random() * (10 - 1) + 1);
	private int level = (int) (Math.random() * (10 - 1) + 1);
	private int experience = (int) (Math.random() * (10 - 1) + 1);
	private int strength = (int) (Math.random() * (10 - 1) + 1);
	private int dexterity = (int) (Math.random() * (10 - 1) + 1);
	private int charisma = (int) (Math.random() * (10 - 1) + 1);
	private int battlesWon = (int) (Math.random() * (10 - 1) + 1);
	private int life = (int) (Math.random() * (10 - 1) + 1);

	public Fighter(String name, String trashTalk, String[] inventory, String shirt, String pants, boolean petting,
			boolean running, int speed, int level, int experience, int strength, int dexterity, int charisma,
			int battlesWon, int life) {
		super();
		this.name = name;
		this.trashTalk = trashTalk;
		this.inventory = inventory;
		this.shirt = shirt;
		this.pants = pants;
		this.petting = petting;
		this.running = running;
		this.speed = speed;
		this.level = level;
		this.experience = experience;
		this.strength = strength;
		this.dexterity = dexterity;
		this.charisma = charisma;
		this.battlesWon = battlesWon;
		this.life = life;
	}
	
	public Fighter(String name, boolean running, int speed, int level, int experience, int strength, int dexterity,
			int charisma, int battlesWon, int life) {
		super();
		
		Fighter enemy = new Fighter();
		enemy.name = name;
		enemy.running = running;
		enemy.speed = speed;
		enemy.level = level;
		enemy.experience = experience;
		enemy.strength = strength;
		enemy.dexterity = dexterity;
		enemy.charisma = charisma;
		enemy.battlesWon = battlesWon;
		enemy.life = life;
	}

	public Fighter() {
		Fighter newFighter = new Fighter();
		newFighter.name = "";
		newFighter.trashTalk = "";
		newFighter.inventory = null;
		newFighter.shirt = "";
		newFighter.pants = "";
		newFighter.petting = false;
		newFighter.running = false;
		newFighter.speed = 0;
		newFighter.level = 1;
		newFighter.experience = 0;
		newFighter.strength = 1;
		newFighter.dexterity = 1;
		newFighter.charisma = 1;
		newFighter.battlesWon = 0;
		newFighter.life = 0;
	}

	public String getName() {
		return name; // return fighter name
	}

	public void setName(String name) {
		this.name = name; // set fighter name
	}

	public int getSpeed() {
		return speed; // return fighter speed
	}

	public void setSpeed(int speed) {
		this.speed = speed; // set fighter speed

		if (speed > 10)
			speed = 10; // max speed is 10

		if (speed < 0)
			speed = 0; // min speed is 0
	}

	public int getLevel() {
		return level; // return fighter level
	}

	public void setLevel(int level) {
		this.level = level; // set fighter level

		if (level > 20)
			level = 20; // max level is 20

		if (level < 1)
			level = 1; // min level is 1
	}

	public int getExperience() {
		return experience; // return fighter experience
	}

	public void setExperience(int experience) {
		this.experience = experience; // set fighter experience
	}

	public int getStrength() {
		return strength; // return fighter strength
	}

	public void setStrength(int strength) {
		this.strength = strength; // set fighter strength

		if (strength > 20)
			strength = 20; // max strength is 20

		if (strength < 1)
			strength = 1; // min strength is 1
	}

	public int getDexterity() {
		return dexterity; // return fighter dexterity
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity; // set fighter dexterity

		if (dexterity > 20)
			dexterity = 20; // max dexterity is 20

		if (dexterity < 1)
			dexterity = 1; // min dexterity is 1
	}

	public int getCharisma() {
		return charisma; // return fighter charisma
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma; // set fighter charisma

		if (charisma > 20)
			charisma = 20; // max charisma is 20

		if (charisma < 1)
			charisma = 1; // min charisma is 1
	}

	public int getBattlesWon() {
		return battlesWon; // return battles won
	}

	public void setBattlesWon(int battlesWon) {
		this.battlesWon = battlesWon; // set battles won
	}

	public int getLife() {
		return life; // return fighter life
	}

	public void setLife(int life) {
		this.life = life; // set fighter life

		if (dexterity > 100)
			dexterity = 100; // max dexterity is 100

		if (dexterity < 0)
			dexterity = 0; // min dexterity is 0
	}

	public void run(boolean running, int speed) {
		// A method that will indicate the fighter is running. It might set a
		// speed property higher
		running = true;

		if (speed < 8) // if fighter is not already running (below 8) then speed
						// is set to full
			speed = 10;
	}

	public void walk(boolean running, int speed) {
		// A method that would probably set the fighter's speed lower than
		// running but higher than 1
		running = false;

		if (speed > 3)
			speed = 2;
	}

	public void stop(boolean running, int speed) {
		running = false;
		speed = 0;
	}

	public void talk(int charisma) {
		// A method that simulates talking to someone/something and uses the
		// fighter�s charisma value

		// Your player converses with others, +1 charisma
		if (charisma < 10)
			charisma++;
	}

	public void fight() {
		// A method that controls a battle. Attributes (Level, Strength,
		// Dexterity, etc.) will be used

		Fighter f = new Fighter(name, trashTalk, inventory, shirt, pants, petting, running, speed, level, experience,
				strength, dexterity, charisma, battlesWon, life);

		// Create fighter with random stats
		int level2 = (int) (Math.random() * (20 - 1) + 1);
		int strength2 = (int) (Math.random() * (20 - 1) + 1);
		int dexterity2 = (int) (Math.random() * (20 - 1) + 1);
		int charisma2 = (int) (Math.random() * (20 - 1) + 1);
		int speed2 = (int) (Math.random() * (10 - 1) + 1);
		int life2 = 100;
		setLife(100); // reset fighter health to 100

		do {
			// Compare stats and declare winner

			// compare level, decrease life by x2 level difference
			int temp = f.getLevel() - level2;
			if (f.getLevel() > level2)
				life2 -= (temp * 2);
			else if (f.getLevel() < level2)
				f.setLife(f.getLevel() - (temp * -2));

			// compare strength, decrease life by x2 strength difference
			temp = f.getStrength() - strength2;
			if (f.getStrength() > strength2)
				life2 -= (temp * 2);
			else if (f.getStrength() < strength2)
				f.setLife(f.getLife() - (temp * -2));

			// compare dexterity, decrease speed by 1
			if (f.getDexterity() > dexterity2)
				speed2 -= 1;
			else if (f.getDexterity() < dexterity2)
				f.setSpeed(f.getSpeed() - 1);

			// compare charisma, decrease charisma by 3
			if (f.getCharisma() > charisma2)
				charisma2 -= 3;
			else if (f.getCharisma() < charisma2)
				f.setCharisma(f.getCharisma() - 3);

			// compare speed, decrease life by 5
			if (f.getSpeed() > speed2)
				life2 -= 5;
			else if (f.getSpeed() < speed2)
				f.setLife(f.getLife() - 5);

		} while (!(f.getLife() < 0 || life2 < 0)); // loop while both fighters
													// are still alive
	}

	public String trashTalk(String trashTalk, int charisma) {

		// Charisma decreases when fighter trash talks
		if (charisma > 0)
			charisma--;

		return trashTalk; // returns pre-set trash-talk phrase
	}

	public void pickUp(String item, String[] inventory) {
		// Add item to inventory
		int x = 1; // set inventory space to place item
		inventory[x] = item;
	}

	public void drop(String[] inventory) {
		// Remove item from inventory
		int x = 1; // set which inventory space to empty
		inventory[x] = "";
	}

	public void petAnimal(boolean petting) throws InterruptedException {

		petting = true; // fighter is currently petting animal
		Thread.sleep(3000); // fighter is petting animal for 3 seconds
		petting = false; // fighter is no longer petting animal
	}

	public void changeClothes(String shirt, String pants, String shirtColor, String pantsColor) {

		// change shirt color
		shirt = shirtColor;

		// change pants color
		pants = pantsColor;
	}

	public void eat(int life) {

		// fighter eats food and increases health by 4
		life += 4;

		if (life > 100)
			life = 100; // makes sure life does not surpass 100
	}

} // end class