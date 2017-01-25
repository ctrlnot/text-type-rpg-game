/**
 * @(#)Setup.java
 *
 *
 * @author 
 * @version 1.00 2016/8/26
 */

import java.util.Random;

public class Setup {
	
	// set random object
	
    Random rand = new Random();
	
	// setup game variables
	private int health, damage, potions, potionHeal, dropPotionRate;
	private int enemyMaxHealth, enemyHealth, enemyDamage;
	private String playerName, enemy;

	// set default values
    public Setup() {
    	this.health = 150;
    	this.damage = 40;
    	this.potions = 3;
    	this.potionHeal = 50;
    	this.dropPotionRate = 30;
    	this.enemyMaxHealth = 100;
    	this.enemyDamage = 40;
    	this.playerName = "You";
    	this.enemy = getEnemy();
    }
    
    public int getEnemyMaxHealth(){
    	return this.enemyMaxHealth;
    }
    
    public int getEnemyDamage(){
    	return this.enemyDamage;
    }
    
    public int getHealth(){
    	return this.health;
    }
    
    public int getDamage(){
    	return this.damage;
    }
    
    public int getPotions(){
    	return this.potions;
    }
    
    public int getPotionHeal(){
    	return this.potionHeal;
    }
    
    public int getDropPotionRate(){
    	return this.dropPotionRate;
    }
    
    public String getEnemy(){
    	String[] enemies = {
    		"Responsibility", "Committment", "Person", "School Work"
    	};
    	String enemy = enemies[rand.nextInt(enemies.length)];
    	return enemy;
    }
    
    // For output messages
    
    public void print(String msg){
    	System.out.println(msg);
    }
    
    // Testing default values
    public String toString(){
    	return health + "\n" + damage + "\n" + potions + "\n" + potionHeal + "\n" + dropPotionRate + "%\n"
    			+ enemyMaxHealth + "\n" + enemyDamage + "\n"
    			+ playerName + "\n" + enemy + "\n";
    }
    
}