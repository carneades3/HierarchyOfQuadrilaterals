
import java.math.BigDecimal;
import java.util.ArrayList;

public class Trapezoid extends Quadrilateral {
   private static final int NUMBER_OF_PARALLEL_PAIRS_OF_SIDES = 1;

   public Trapezoid(Point... pointsArray) {
      super(pointsArray);
      checkSides(LinesRelation.PARALLEL, NUMBER_OF_PARALLEL_PAIRS_OF_SIDES, false);
   }
   
   protected final void checkSides(LinesRelation relation, int pairs, boolean exactly) {
      int relationPairsOfSides = calculateSidesPairRelations(relation);
      if (true == exactly) {
         if (relationPairsOfSides != pairs) {
               String message = String.format("%s %n must have exactly %d pairs of %s sides", this, pairs, relation);
               throw new IllegalArgumentException(message);
         }
      }
      else {   // if (false == exactly) {
         if (relationPairsOfSides < pairs || relationPairsOfSides > 2) {
               String message = String.format("%s %n must have %d (maximum 2) pairs of %s sides", this, pairs, relation);
               throw new IllegalArgumentException(message);
         }  
      }
   }
   
   public BigDecimal calculateArea() {
      ArrayList<Integer> basesSidesIndexes = super.getSidesWithRelations(LinesRelation.PARALLEL, 2);
      LineSegment firstBase  = super.getSide(basesSidesIndexes.get(0));
      LineSegment secondBase = super.getSide(basesSidesIndexes.get(1));
      
      final BigDecimal HEIGHT             = calculateHeight(firstBase, secondBase);
      final BigDecimal FIRST_BASE_LENGTH  = firstBase.calculateLength();
      final BigDecimal SECOND_BASE_LENGTH = secondBase.calculateLength();
      
      BigDecimal result = FIRST_BASE_LENGTH.add(SECOND_BASE_LENGTH, Line.MATH_CONTEXT);
      result            = result.multiply(HEIGHT, Line.MATH_CONTEXT);
      result            = result.divide(new BigDecimal(2, Line.MATH_CONTEXT), Line.MATH_CONTEXT);
      
      return result;
   }
   
   protected final BigDecimal calculateHeight(LineSegment firstBase, LineSegment secondBase) {
      ValidateParameters.checkNullPointer(firstBase, secondBase);
      
      Point firstBaseExtremity = firstBase.getExtremity(0);
      Line  secondBaseLine     = secondBase.getLine();
      final BigDecimal HEIGHT  = secondBaseLine.calculateDistance(firstBaseExtremity);
      
      return HEIGHT;
   }
} 
