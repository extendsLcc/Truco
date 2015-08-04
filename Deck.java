import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck extends Actor
{
    
    ArrayList < Card > deck =  new ArrayList < Card >();
    
    public Deck(){
    
        //getImage().clear();
    
    }
    
    public void generateDeck(){

        int deck[] = new int[10];
        int naipes[][] = new int[10][4];
        World world = getWorld();

        while( this.deck.size() < 40){

            int random = Greenfoot.getRandomNumber( 10 );

            if ( deck[random] < 4 ){

                while( true ){
                    
                    int rnd = Greenfoot.getRandomNumber( 4 );
                    
                    if ( naipes[random][rnd] < 1 ){
                    
                        deck[random] ++;
                        naipes[random][rnd] ++;
                        Card c = new Card( random, rnd );
                        world.addObject( c, 200, 200 );
                        this.deck.add( c );
                        break;
                        
                    }
                    
                }

            }
            
        }
        
    }
    
    public void shuffleDeck( /*int x, int y*/ ){
        
        int x = 560;
        int y = 200;
    
        ArrayList < Card > l = new ArrayList < Card >();
        World w = getWorld();
        int cards = 0;
        
        for( Card c : deck ){
        
            w.removeObject( c );
            if( c.isFliped() )c.flip();
            
        }
        
        while( cards < 40 ){
        
            int i  = Greenfoot.getRandomNumber( deck.size() );
            
            if( ! l.contains( deck.get( i ) ) ){
            
                Card c = deck.get( i );
                l.add( c );
                deck.remove( c );
                w.addObject( c, x - cards, y - ( cards * 2 ) );
                cards ++;
                Greenfoot.delay( 1 );
                
            }
        
        }
        
        deck.clear(); //!! só pra ter certeza
        deck.addAll( l );
        //vira().flip();
        //vira().dragTo( 0, (int) Math.round( polarX( vira().getX(), 50, 135 ) ), (int) Math.round( polarY( vira().getY(), 50, 135 ) ) );
        
    }
    
}
