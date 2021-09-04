
public enum LinesRelation {
   IDENTICALLY("identical"),
   PARALLEL("parallel"),
   INTERSECTING("intersecting"),
   PERPENDICULAR("perpendicular");
   
   private String name;
   
   private LinesRelation(String name) {
      this.name = name;
   }
   
   public String toString() {
      return name;
   }
} 

