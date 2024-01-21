package Effective_Java;

import java.util.*;

public class PowerSet {
    public static final <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
            if(src.size() > 30) {
                throw new IllegalArgumentException("집합에 원소가 너무 많습니다(최대 30개).: " + s);
            }
            
            return new AbstractList<Set<E>>() {
                @Override
                public int size() {
                    return 1 << src.size();
                }
                
                @Override
                public boolean contains(Object o) {
                    return o instanceof Set && src.containsAll((Set) o);
                }
                
                @Override
                public Set<E> get(int index) {
                    Set<E> result = new HashSet<>();
                        for (int i = 0; index != 0; i++, index >>=1) {
                            if((index & 1) == 1) { //index는 멱집합을 가지고 있는 Set<E>
                            //src는 각 멱집합의 원소를 가진 객체
                            //index가 5이면 -> 101 이므로 a,c 를 가지고 있을 것이다.
                                result.add(src.get(i));
                            }
                        }
                        return result; // 만들어진 집합 리턴
                    }
                };
            }
        }
