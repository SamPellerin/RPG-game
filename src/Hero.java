public class Hero extends Individual {
    // We define the Hero's attributes.
    private static int enemyDefeated , level , maxHealth;

    // Constructor of the Hero class.
    public Hero( int attackPts , int health ) {
        super( attackPts , health );
        enemyDefeated = 0;
        level = 1;
        maxHealth = this.getHealth();
    }

    // We define the getters and setters for the class Individual.
    public int getEnemyDefeated() {
        return enemyDefeated;
    }
    public int getLevel() { return level; }
    public int getMaxHealth() { return maxHealth; }

    public void setMaxHealth( int maxHealth ) { Hero.maxHealth = maxHealth; }
    public void setEnemyDefeated( int enemyDefeated ) { Hero.enemyDefeated = enemyDefeated; }
    public void setLevel( int level ) { Hero.level = level; }

    // The method resting brings the hero's health to its maximum.
    public void resting() {
        this.setHealth( this.getMaxHealth() );
    }

    // The method healing increases the hero's health by the integer specified. The hero's health cannot
    // exceed it's maxHealth.
    public void healing( int healthIncrease ) {
        this.setHealth( Math.min( this.getMaxHealth() , this.getHealth() + healthIncrease ) );
    }

    // The method training increases the hero's attack damage by the amount specified
    // by the parameter upgrade.
    public void training( int attackIncrease ) {
        this.setAttackPts( this.getAttackPts() + attackIncrease );
    }

    // The method adjustingLevel looks at the XP of the player, and it
    // increases the hero's level if it has enough XP pour next level.
    public void adjustingLevel( int nextLevel ){
        if ( 50 + nextLevel * 20 * Math.pow( 1.1 , nextLevel ) <= this.getExperience() ) {
            this.setLevel( this.getLevel() + 1 );
            this.setExperience( 0 );
            this.setMaxHealth( this.getMaxHealth() + 12 );
            this.resting();
            this.setAttackPts( this.getAttackPts() + 6 );
        }
    }
}