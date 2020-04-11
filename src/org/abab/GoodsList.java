package org.abab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GoodsList {
    private final List<Goods> goodsList;

    public GoodsList(List<String> pList) {
        this.goodsList = new ArrayList<>();
        Collections.sort(pList);
        addGoods(pList);

        goodsList.sort(Comparator.comparingInt((Goods g) -> -g.quantity));
    }

    public List<Goods> range(int start, int end) {
        List<Goods> result = new ArrayList<>();

        for (int i = start - 1; i < end; i++) {
            result.add(this.goodsList.get(i));
        }

        return result;
    }

    private void addGoods(List<String> pList) {
        for (String p : pList) {
            // 商品リストが空だったら、最初の商品を商品リストに追加する
            if (goodsList.isEmpty()) {
                goodsList.add(new Goods(p, 1));
            } else {
                Goods latestGoods = goodsList.get(goodsList.size() - 1);

                // もし、最後の商品が追加しようとしている商品と同じ種類だったら、最後の商品の数を+1する
                if (latestGoods.name.equals(p)) {
                    goodsList.set(goodsList.size() - 1, latestGoods.add());
                    // もし、最後の商品が今まで出たことがない商品だったら、その商品リストに新しい商品を追加する
                } else {
                    goodsList.add(new Goods(p, 1));
                }
            }
        }
    }
}
