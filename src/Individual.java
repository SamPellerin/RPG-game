public class Individual {

    // We define the Individual's attributes. The experience is set to 0 by default.
    private int attackPts , health;
    private static int experience;

    // Constructor of the Individual class.
    public Individual( int attackPts, int health ) {
        this.attackPts = attackPts;
        this.health = health;
        experience = 0;
    }

    // We define the getters and setters for the class Individual.
    public int getHealth() { return this.health; }
    public int getExperience() { return Individual.experience; }
    public int getAttackPts() { return this.attackPts; }

    public void setHealth( int health ) { this.health = health; }
    public void setAttackPts( int attackPts ) { this.attackPts = attackPts; }
    public void setExperience( int experience ) { Individual.experience = experience; }

    // The method loseHealth takes an integer as a parameter, and reduces the health of
    // the individual by this amount, and returns true if the individual is still alive.
    public boolean loseHealth( int damage ) {
        this.setHealth( this.getHealth() - damage );
        return this.getHealth() > 0;
    }

    // The method engageInDuel handles a 1v1 between two individuals.
    // The instance on which we call the method is the individual which engages the duel,
    // so this instance will attack first.
    public boolean engageInDuel( Individual opponent ) {
        int i = 0;
        while (true) {
            // We impose a condition on the iterator i to determine if it's the hero's turn to attack or the enemy's.
            if ( i % 2 == 0 ) {
                // If the opponent dies, we return True.
                if ( !( opponent.loseHealth( this.getAttackPts() ) ) ){
                    return true;
                }
            } else {
                // If the individual which engages the duel dies, we return False.
                if ( !( this.loseHealth( opponent.getAttackPts() ) ) ) {
                    return false;
                }
            }
            i++;
        }
    }
}