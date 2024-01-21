package Effective_Java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Item38 {
    // Operation
    public interface Operation {
        double apply(double x, double y);
        default double plus(double x, double y){
            return x+y;
        }
        default double minus(double x, double y){
          return x-y;
      }

    }
  
  // BasicOperation
    public enum BasicOperation implements Operation {
        PLUS("+") {
        public double apply(double x, double y) { return x + y; }
        },
        MINUS("-") {
        public double apply(double x, double y) { return x - y; }
        },
        TIMES("*") {
        public double apply(double x, double y) { return x * y; }
        },
        DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
        };
        private final String symbol;
    
        BasicOperation(String symbol) {
        this.symbol = symbol;
        }
    
        @Override public String toString() {
        return symbol;
        }
    }
  
  // ExtendedOperation
  public enum ExtendedOperation implements Operation {
      EXP("^") {
       public double apply(double x, double y) {
         return Math.pow(x, y);
       }
      },
      REMAINDER("%") {
       public double apply(double x, double y) {
         return x % y;
       }
      },
      PLUS("+"){
        @Override
        public double plus(double x, double y) {
          return super.plus(x, y);
        }

        @Override
        public double apply(double x, double y) {
          // TODO Auto-generated method stub
          throw new UnsupportedOperationException("Unimplemented method 'apply'");
        }
      },
      MINUS("-") {
        @Override
        public double minus(double x, double y) {
          return super.minus(x, y);
        }

        @Override
        public double apply(double x, double y) {
          // TODO Auto-generated method stub
          throw new UnsupportedOperationException("Unimplemented method 'apply'");
        }
        
      };
      private final String symbol;
      ExtendedOperation(String symbol) {
       this.symbol = symbol;
   }
  
    @Override public String toString() {
        return symbol;
    }
  }
  public static void main(String[] args) {
    double x = Double.parseDouble("4.0");
    double y = Double.parseDouble("2.0");
    
    test(ExtendedOperation.class, x, y);
}

private static <T extends Enum<T> & Operation> void test(
    Class<T> opEnumType, double x, double y) {
    for (Operation op : opEnumType.getEnumConstants()){
      if(op.toString().equals("+")){
        System.out.printf("%f %s %f = %f%n", x, op, y, op.plus(x, y));
      
      }else if(op.toString().equals("-")){
        System.out.printf("%f %s %f = %f%n", x, op, y, op.minus(x, y));
      }else{
        System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
      }

    }
}

}
