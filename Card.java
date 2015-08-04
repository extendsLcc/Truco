import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    
    private int simbol;
    private int naipe;
    
    private boolean flip = false;
    private GreenfootImage cardFace;
    
    private static final GreenfootImage background = new GreenfootImage( "background.png" );
    private static final GreenfootImage allFaces = new GreenfootImage( "classic-playing-cards.png" );
    
    public Card( int simbol, int naipe ){
    
        this.simbol = simbol;
        this.naipe = naipe;
        
        setImage( background );
        cardFace = Sprite.getSprite( allFaces, 73, 98, simbol + naipe * 10, 73, 98 );
        
    }
    
    public boolean isFliped(){
    
        return flip;
        
    }
    
    public void flip(){
    
        if( flip ){
        
            setImage( background );
            
        }else
            setImage( cardFace );
            
        flip = !flip;
    
    }
    
    private int[] simbolPower = { 2, 1, 0, 9, 8, 7, 6, 5, 4, 3 };
    private int[] naipePower = { 3, 1, 2, 0 };
    
    public int getCardPower( Card manilha ){
        
        int tmp = simbol - 1 == -1 ? 9 : simbol - 1;
        
        if( manilha.simbol == tmp ){
        
            for( int i = 0; i < naipePower.length; i ++){
            
                return -( i + 1 );
            
            }
            
        }
        
        for( int i = 0; i < simbolPower.length; i ++ ){
        
            if( simbol == simbolPower[i] )
                return i;
            
        }
    
        return 99;// erro
        
    }
    
    public void atualize(){
    
        World w = getWorld();
        int x = getX(), y = getY();
        w.removeObject( this );
        w.addObject( this, x, y );
        
    }
    
}
