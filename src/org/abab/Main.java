package org.abab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<String> pList = new ArrayList<>();

        // 購入者ループ
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            // 商品るーぷ
            for (int j = 0; j < m; j++) {
                pList.add(scanner.next());
            }
        }

        GoodsList goodsList = new GoodsList(pList);

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            List<Goods> partialGoods = goodsList.range(scanner.nextInt(), scanner.nextInt());

            for (Goods g : partialGoods) {
                System.out.println(g);
            }
        }
    }
}
