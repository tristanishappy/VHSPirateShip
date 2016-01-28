public class Grid
{
   private Location[][] grid;
   private static final int NUM_ROWS = 16;
   private static final int NUM_COLS = 16;
    
   public Grid()
   {
      grid = new Location[NUM_ROWS][NUM_COLS];
      for(int i = 0; i < NUM_ROWS; i++)
      {
         for(int j = 0; j < NUM_COLS; j++)
         {
            grid[i][j] = new Location();
         }
      }
   }
   public void printGrid()
   {
      for(int i = 0; i < NUM_ROWS; i++)
      {
         System.out.println();
         for(int j = 0; j < NUM_COLS; j++)
         {
            if(grid[i][j].getType() == 0)
            {
               System.out.print("~");
            }
            else
            {
               System.out.print(grid[i][j].getType());
            }
         }
      }
   }
}