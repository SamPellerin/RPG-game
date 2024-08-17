public final class Enemy extends Individual {
    // Constructor of the class Enemy. We set the enemy's attackPts and health in function of the number of
    // enemy defeated. The experience won by defeating this enemy is also dependent of the number of enemy defeated.
    public Enemy( int enemyDefeated ) {
        super( 25 + 5 * enemyDefeated , 100 + 10 * enemyDefeated );
        setExperience( 35 + 8 * enemyDefeated );
    }
}
