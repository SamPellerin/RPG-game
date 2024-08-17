public final class HeroAttack extends Hero {
    // Constructor of the HeroAttack class.
    public HeroAttack( int attackPts , int health ) {
        super( attackPts , health );
    }

    @Override
    // We override the method engageInDuel defined in the class Individual to accommodate the difference in stats
    // that arises from the hero's attack class.
    public boolean engageInDuel( Individual opponent ) {
        int i = 0;
        while ( true ) {
            if ( i % 2 == 0 ) {
                if ( !( opponent.loseHealth( this.getAttackPts() * 2 ) ) ) {
                    return true;
                }
            } else {
                if ( !( this.loseHealth( opponent.getAttackPts() * 2 ) ) ) {
                    return false;
                }
            }
            i++;
        }
    }
}

