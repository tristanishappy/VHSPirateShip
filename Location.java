public class Location
{
   public static final int WATER = 0;
   public static final int ISLAND = 1;
   public static final int SHIP = 3;
   
   private int type;
   
   public Location()
   {
      this.type = WATER;
   }
   
   public int getType()
   {
      return this.type;
   }
   
   public void setType(int type)
   {
      this.type = type;
   }
}