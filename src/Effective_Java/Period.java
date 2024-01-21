// package Effective_Java;

// import java.io.Serializable;
// import java.util.Date;

// // 방어적 복사를 사용하는 불변 클래스
// public final class Period implements Serializable{
//     private final Date start;
//     private final Date end;
    
//     /**
//      * @param start 시작 시각
//      * @param end 종료 시각; 시작 시각보다 뒤여야 한다.
//      * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
//      * @throws NullPointerException start나 end가 null이면 발행한다.
//      */
//     public Period(Date start, Date end) {
//         this.start = new Date(start.getTime());
//         this.end = new Date(end.getTime());
//         if(this.start.compareTo(this.end) > 0) {
//             throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
//         }
//     }
    
//     public Date start() { return new Date(start.getTime()); }
//     public Date end() { return new Date(end.getTime()); }
//     public String toString() { return start + "-" + end; }
// }

