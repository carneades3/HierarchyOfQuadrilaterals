
import java.math.BigDecimal;

public class Rectangle extends Parallelogram {
   private static final int NUMBER_OF_PERPENDICULAR_PAIRS_OF_SIDES = 4;
   
   public Rectangle(Point... pointsArray) {
      super(pointsArray);
      checkSides(LinesRelation.PERPENDICULAR, NUMBER_OF_PERPENDICULAR_PAIRS_OF_SIDES, true);
   }
   
   @Override
   public BigDecimal calculateArea() {
      LineSegment side         = getSide(0);
      LineSegment nextSide     = getSide(1);
      
      final BigDecimal SIDE_LENGTH       = side.calculateLength();
      final BigDecimal NEXT_SIDE_LENGTH  = nextSide.calculateLength();
      
      BigDecimal result = SIDE_LENGTH.multiply(NEXT_SIDE_LENGTH, Line.MATH_CONTEXT);
      
      return result;
   }
} 
