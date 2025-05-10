package LeetCode;

import java.util.*;

public class InsertDeleteGetRandom {
    // Map과 List를 혼합하여 사용하여야 99.86% Beat 할 수 있고 이렇게 짜게 되면 5%만 Beat 할 수 있다.
    // 즉, Index를 빠르게 찾기 위해서는 Map으로 Search하고 List를 초기화 시켜야 한다.
    // 코드상에 contains 부분을 Map으로 모두 치환 시키는 것이 훨씬 빠름
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}


class RandomizedSet {
    List<Integer> list;
    public RandomizedSet() {
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!list.contains(val)){
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(list.contains(val)){
            list.remove(list.indexOf(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(0, list.size()));
    }
}
