import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife 
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 5 rows and 5 columns
    private final int ROWS = 10;
    private final int COLS = 10;
    
    // constants for the location of the three cells initially alive
    private final int X1 = 2, Y1 = 2;
    private final int X2 = 3, Y2 = 2;
    private final int X3 = 4, Y3 = 2;
    private final int X4 = 6, Y4 = 5;
    private final int X5 = 6, Y5 = 6;
    private final int X6 = 6, Y6 = 7;
    private final int X7 = 5, Y7 = 6;
    
//    private final int X4 = 5, Y4 = 6;

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        // populate the game
        populateGame();
        
        // display the newly constructed and populated world
        world.show();
        
        
    }
    
    public void generateThirdGeneration()
    {
    	try
    	{
    		 Thread.sleep(2000);
    		 createNextGeneration();
    	        Thread.sleep(2000);
    	        createNextGeneration();
    	        Thread.sleep(2000);
    	        createNextGeneration();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *arg0
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        
        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        rock1.setColor(Color.BLUE);
        Location loc1 = new Location(X1, Y1);
        grid.put(loc1, rock1);
        
        Rock rock2 = new Rock();
        Location loc2 = new Location(X2, Y2);
        rock2.setColor(Color.CYAN);
        grid.put(loc2, rock2);
        
        Rock rock3 = new Rock();
        Location loc3 = new Location(X3, Y3);
        rock3.setColor(Color.GREEN);
        grid.put(loc3, rock3);
                
        Rock rock4 = new Rock();
        Location loc4 = new Location(X4, Y4);
        grid.put(loc4, rock4);
        
        Rock rock5 = new Rock();
        Location loc5 = new Location(X5, Y5);        
        grid.put(loc5, rock5);
        
        Rock rock6 = new Rock();
        Location loc6 = new Location(X6, Y6);
        grid.put(loc6, rock6);
        
        Rock rock7 = new Rock();
        Location loc7 = new Location(X7, Y7);
        grid.put(loc7, rock7);
    }

    
    // every generation the color combination will change
    public Color getRandomColor()
    {    	
    	Color color;
    	Random random = new Random();
    	int colorNum = random.nextInt(6) + 1;
    	switch (colorNum)
    	{
	    	case 1: color = Color.BLUE;break;
	    	case 2: color = Color.GREEN;break;
	    	case 3: color = Color.ORANGE;break;
	    	case 4: color = Color.RED;break;
	    	case 5: color = Color.MAGENTA;break;
	    	case 6: color = Color.CYAN;break;
			default: color = Color.black;break;
    	}
    		
    	
    	return color;
    }
    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
       
    public void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        
       // world.setGrid(grid);
        
        // insert magic here...
        int x=0;
        int y=0;
        
        // this is for storing whether or not the new cells live in the next generations
        List<Location> newNextGen = new ArrayList<Location>();
        
        // this is for removing cells in the next generation
        List<Location> removeNextGen = new ArrayList<Location>();
        //alive cells around one cell
        List <Location> occupiedList;
        
        Actor actor;
        
        Location cell = new Location(x,y);
        
        /*
         * Outer loop will test for 
         */
        for (x = 0; x < ROWS; x++)
        {
        	
        	for(y = 0; y < COLS; y++)
        	{
        		cell = new Location(x,y);
        		actor = grid.get(cell);
        		occupiedList = grid.getOccupiedAdjacentLocations(cell);
        		//System.out.println(occupiedList);
        		if (actor != null)
        		{
        		// if  live cell with fewer than two live neighbors or greater than three neighbors dies
        			if(occupiedList == null || occupiedList.size() < 2 || occupiedList.size() > 3 )
        			{
        				removeNextGen.add(cell);
        			}
        			// else the actor moves to the next generation so do not need to do anything with this cell
        		}
        		else  // if it is dead
        		{
        			if (occupiedList.size() == 3)
        			{
        				newNextGen.add(cell);
        			}
        		}
        	}
        }
        
        Rock rock1 = new Rock();
        rock1.setColor(getRandomColor());
        Location loc = null;
                
        for(int i = 0; i < newNextGen.size(); i++)
        {
        	loc = newNextGen.get(i);
        	grid.put(loc,rock1 );
        }
    
        for(int i = 0; i < removeNextGen.size(); i++)
        {
        	loc = removeNextGen.get(i);
        	grid.remove(loc);
        }

        System.out.println("grid "+grid);
        world.show();
        
        
    }
    
   
    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
    
    
    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args) throws Exception
    {
    	int count=0;
    	try{
	    	GameOfLife game = new GameOfLife();
	    
	        
	        while(count<54) {
	        	//System.out.println("Run no  = "+count);
	        	Thread.sleep(2000);
	        	game.createNextGeneration();
	        	count++;
	        	
	        }
        }catch(Exception e)
        {
        	//System.out.println("Exception at  = "+count);
        	e.printStackTrace();
        	throw e;
        }
        
        
    }

}
