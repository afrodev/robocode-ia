package testrobot;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Testrobot - a robot by (your name here)
 */
public class Testrobot extends Robot
{

	/* 	State = 0 
		** Procura uma parede
		State = 1 
		** Achou uma parede e precisa andar para frente
		State = 2
		** Achou uma parede e precisa andar pra trás
*/
	int state = 0;
	
	/**
	 * run: Testrobot's default behavior
	 */
	public void run() {
		setAdjustGunForRobotTurn(true);
//		turnRadarRight(180);
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		//setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			//turnRadarRight(30);
			turnGunLeft(180);
			turnRight(45);

			if (state == 0)  {
				// Replace the next 4 lines with any behavior you would like
				ahead(1000);
	
				//turnGunRight(360);
				//back(100);
				//turnGunRight(360);
				//state = 1;		
				System.out.println("estado 0");		
			} else if (state == 1) {
				//turnGunRight(180);
				back(1000);
				System.out.println("estado 1");
				//turnGunRight(10);
			} else if (state == 2) {
			 	//turnGunRight(180);
				ahead(1000);
				
				System.out.println("estado 2");
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(3);
		ahead(500);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(500);
		//turnGunRight(360);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		switch (state) {
			case 0:
				this.state = 1;
				break;
			case 1:
				this.state = 2;
				break;
			case 2: 
				//turnRadarRight(180);
				this.state = 0;
			default:
				break;
		}

		
		//back(100);
		//turnGunRight(120);
	}	
}
