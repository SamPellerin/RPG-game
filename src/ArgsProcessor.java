public class ArgsProcessor {
    public static void process( String[] args ) {
        String[] phrase = makePhrase( args[0] );
        Hero hero;
        // We create a new hero with maxHP and attack strength specified in the arguments. If the hero's name starts
        // with the letter A, we instance a hero of class Attack.
        if ( phrase[0].charAt( 0 ) == 'A' ) {
            hero = new HeroAttack( Integer.parseInt( phrase[2] ) , Integer.parseInt( phrase[1] ) );
        }
        // If the hero's name starts with the letter D, we instance a hero of class Defense.
        else if ( phrase[0].charAt( 0 ) == 'D' ) {
            hero = new HeroDefense( Integer.parseInt( phrase[2] ) , Integer.parseInt( phrase[1] ) );
        }
        // If the hero's name starts with another letter, we instance a normal hero, with no modifications to
        // the hero's stats.
        else {
            hero = new Hero( Integer.parseInt( phrase[2] ) , Integer.parseInt( phrase[1] ) );
        }
        // For each sentence, we do the action and we print a losing message if
        // the hero died during that step.
        for ( int i = 3; i < phrase.length; i++ ) {
            if ( !( doAction( phrase[i] , hero ) ) ) {
                System.out.println( "In his quest, " + phrase[0] + " died after beating " +
                        hero.getEnemyDefeated() + " enemies and attaining level " +
                        hero.getLevel() + "!" );
                return;
            }
        }
        // If the hero survived the whole quest, we print a winning message!
        System.out.println( "In his quest, " + phrase[0] + " beat " + hero.getEnemyDefeated() +
                        " enemies, attained level " + hero.getLevel() + " and survived with " +
                hero.getHealth() + "HP!" );
    }
    // The method makePhrase is used to split the sentences in the input.
    private static String[] makePhrase( String args ) {
        return args.trim().split( "," );
    }

    // The method doAction takes the part of the input which describes the action and the hero and does the
    // corresponding action. It returns True if the hero survives and False if it dies.
    private static boolean doAction( String action, Hero hero ) {
        // We transform the string action in an array of strings by splitting action in the different words that
        // are separated by spaces.
        String[] phrase = action.trim().split( " " );

        // The type of action is determined by the first word of the sentence.
        switch ( phrase[0] ) {
            case "fought":
                // We iterate on the different enemies fought by the hero, and we verify if the hero won the fight.
                // If the hero loses, we return False. If the hero wins, we adjust the number of enemy defeated,
                // the hero's experience and it's level. If the hero wins all its fights, we return True.
                for ( int i = 0; i < Integer.parseInt( phrase[1] ); i++ ) {
                    Enemy enemy = new Enemy( hero.getEnemyDefeated() );
                    if ( !( hero.engageInDuel( enemy ) ) ) {
                        return false;
                    }
                    else {
                        hero.setEnemyDefeated( hero.getEnemyDefeated() + 1 );
                        hero.setExperience( hero.getExperience() + enemy.getExperience() );
                        hero.adjustingLevel( hero.getLevel() + 1 );
                    }
                }
                return true;

            case "rested":
                hero.resting();
                break;
            case "healed":
                hero.healing( Integer.parseInt( phrase[1]) );
                break;
            case "trained":
                hero.training( Integer.parseInt( phrase[3]) );
                break;
        }
        return true;
    }
}