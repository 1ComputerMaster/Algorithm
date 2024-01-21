package Effective_Java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Item74 {
    static class Cheese{
        int x;
    }

    private final List<Cheese> cheesesInStock = null;

/**
 * 매장 안의 모든 치즈 목록을 반환한다.
 *
 * @return 치즈 목록
 * @throws IllegalStateException 만약 재고가 null인 경우 발생
 * @throws RuntimeException 비검사 예외 예제
 */
public List<Cheese> getCheeses() throws IllegalStateException{
    if (cheesesInStock == null) {
        throw new NullPointerException("재고가 null입니다.");
    }

    return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
}
}
