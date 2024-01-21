package Effective_Java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

// 가변 공격의 예
public class MutablePeriod {

    //Period 인스턴스
    public final Period period;
    
    public final Date start;
    public final Date end;


    class ObjectArrayOutputStream extends ObjectOutputStream {
        private ByteArrayOutputStream bos;

        public ObjectArrayOutputStream(ByteArrayOutputStream bos) throws IOException {
            super(bos);
            this.bos = bos;
        }

        public byte[] toByteArray() {
            return bos.toByteArray();
        }
    }

    public static final class Period implements Serializable{
        private Date start;
        private Date end;
        
        /**
         * @param start 시작 시각
         * @param end 종료 시각; 시작 시각보다 뒤여야 한다.
         * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
         * @throws NullPointerException start나 end가 null이면 발행한다.
         */
        public Period(Date start, Date end) {
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());
            if(this.start.compareTo(this.end) > 0) {
                throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
            }
        }
        
        public Date start() { return new Date(start.getTime()); }
        public Date end() { return new Date(end.getTime()); }
        public String toString() { return start + "-" + end; }

        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            
            // 가변 요소들을 방어적으로 복사한다.
            start = new Date(start.getTime());
            end = new Date(end.getTime());
            
            // 불변식을 만족하는지 검사한다.
            if(start.compareTo(end) > 0) {
            throw new InvalidObjectException(start + "가 " + end + "보다 늦다.");
            }
        }
    }

    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectArrayOutputStream out = new ObjectArrayOutputStream(bos);
            
            //유효한 Period 인스턴스를 직렬화한다.
            out.writeObject(new Period(new Date(), new Date()));
            
            /**
             * 악의적인 '이전 객체 참조', 즉 내부 Date 필드로의 참조를 추가한다.
             * 상세 내용은 자바 객체 직렬화 명세의 6.4절을 참고하자.
             */
            byte[] ref = {0x71, 0, 0x7e, 0, 5}; // 참조 #5
            bos.write(ref); // 시작 start 필드 참조 추가
            ref[4] = 4; //참조 #4
            bos.write(ref); // 종료(end) 필드 참조 추가
            
            // Period 역직렬화 후 Date 참조를 훔친다.
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            period = (Period) in.readObject();
            start = (Date) in.readObject();
            end = (Date) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pEnd = mp.end;

        //시간을 되돌리자!
        pEnd.setYear(78);
        System.out.println(p);

        //60년대로 회귀!
        pEnd.setYear(10);
        System.out.println(p);
    }
}