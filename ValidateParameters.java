
public class ValidateParameters {
   
   public static void checkNullPointer(Object... objectArray) {
      checkNullPointerOnlyArray(objectArray);
      
      for (Object object : objectArray) {
         if (object == null) {
            throw new NullPointerException();
         }
      }
   }
   
   public static void checkNullPointerOnlyArray(Object[] objectArray) {
      if (objectArray == null) {
         throw new NullPointerException();
      }
   }
   
   public static void checkNullPointersInArrays(Object[]... objectArrays) {
      checkNullPointer(objectArrays); //checkNullPointerOnlyArray(objectArrays);
      
      for (Object[] array : objectArrays) {
         checkNullPointer(array);
      }
   }
   
   public static void checkBlankString(String... stringArray) {
      Object[] objects = stringArray;
      checkNullPointer(objects);
      
      for (String string : stringArray) {
         if (string.isBlank() == true) {
            throw new IllegalArgumentException("blank string");
         }
      }
   }
}
