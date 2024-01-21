import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public final class Sub extends Super {
    //초기화되지 않은 final field 생성자에서 초기화한다.
    private String x;
    
    Sub(String x){
        this.x = x;
    }
    
    //재정의 가능 메서드. 상위 클래스의 생성자가 호출한다.
    @Override public void overrideMe(){
        System.out.println(x);
    }
    
    public static void main(String[] args){
        List<Number> list = new ArrayList<Number>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> test = new ArrayList<>();
        System.out.println(list.toString());
    }
    

}