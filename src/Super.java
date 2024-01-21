import java.time.Instant;
import java.util.AbstractList;
import java.util.Hashtable;
import java.util.List;
    public class Super implements Cloneable{
        //잘못된 예 - 생성자가 재정의 가능 메서드를 호출한다.
        public Super(){
            overrideMe();
        }
        public void overrideMe(){
        }
        
        private static class test{
            @Override
            protected Object clone() throws CloneNotSupportedException {
                // TODO Auto-generated method stub
                return super.clone();
            }
        }
    }
    
   