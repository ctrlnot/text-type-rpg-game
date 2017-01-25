/**
 * @(#)RPGExe.java
 *
 * RPGExe application
 *
 * @author Johnston Perocho
 * @version 1.00 2016/8/26
 */
 
import java.util.Random;
import java.util.Scanner;
 
public class RPGExe {
    public static void main(String[] args) {
    	
    	// Initiate objects
    	Scanner in = new Scanner(System.in);
      	Random rand = new Random();
    	Setup play = new Setup();
    	
    	boolean gameRunning = true;
    	int health = play.getHealth();
    	
    	System.out.println("\t\t\t\t Welcome to the Dungeon!");
    	
    	GAME:
    		while(gameRunning){
    			play.print("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    			int enemyHealth = rand.nextInt(play.getEnemyMaxHealth());
			    int potions = play.getPotions();
    			String enemy = play.getEnemy();
    			play.print("\t\t\t ### A wild " + enemy + " appears! ###");
    			
    			while(enemyHealth > 0){
    				play.print("\t Your hp:" + health);
			        play.print("\t " + enemy + "'s hp:" + enemyHealth);
			        play.print("\t What will you do?");
			        play.print("\t\t 1. Attack");
			        play.print("\t\t 2. Drink potion");
			        play.print("\t\t 3. Run!");
			        
			        String input = in.nextLine();
			        
			        if(input.equals("1")){
			        	int damageDealth = rand.nextInt(play.getDamage());
          				int damageTaken = rand.nextInt(play.getEnemyDamage());
          				
          				enemyHealth -= damageDealth;
          				health -= damageTaken;
          				
          				play.print("\t> You attacked " + enemy + " and dealth " + damageDealth + " damage!");
			        	play.print("\t> You received " + damageTaken + " damage..");
			        	
			        	if(health < 1){
							play.print("\t> You dieded :(");
							break;
						}
			        } else if (input.equals("2")) {
			        	if(potions > 0){
			        		health += play.getPotionHeal();
			        		potions--;
			        		
			        		play.print("\t> You drink a potion, you heal yourself for " + play.getPotionHeal() + ".");
			        		play.print("\t> You now have " + health + " hp.");
			        		play.print("\t> Potions left: " + potions + ".");
			        	} else {
			        		play.print("\t> You have no potions left :( Kill enemy for a change of potion drop!");
			        	}
			        } else if (input.equals("3")) {
			        	play.print("\t> You run away from the " + enemy + "!");
          				continue GAME;
			        } else {
			        	play.print("\t Invalid command!");
			        }
    			}
    			
    			if(health < 1){
    				play.print("\t> Rest in RIP :( GAME OVER!");
        			break;	
    			}
    			
    			play.print("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	    		play.print("\t\t\t ### " + enemy + " defeated! ###");
				play.print("\t> You have " + health + " hp left..");
	    		if(rand.nextInt(100) < play.getDropPotionRate()){
	    			potions++;
					play.print("\t> The " + enemy + " dropped a potion!");
					play.print("\t> You now have " + potions + " potion(s)..");
	    		}
    			play.print("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	    		play.print("\t What will you do now?");
				play.print("\t\t 1. Continue");
				play.print("\t\t 2. Exit dungeon");
				
				String input = in.nextLine();
			
				while(!input.equals("1") && !input.equals("2")){
					System.out.println("\t Invalid command!");
					input = in.nextLine();
				}
				
				if(input.equals("1")){
					play.print("\t> You continued your adventure!");
				} else if (input.equals("2")) {
					play.print("\t> You exited to the dungeon safely...");
					break;
				}
    		}
    	
    	play.print("\n\n======================================");
    	play.print("========= THANKS FOR PLAYING! ========"); 
    	play.print("======================================\n\n");
    	
    }
}
