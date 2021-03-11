package com.zx;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import javafx.scene.effect.Bloom;

/**
 * @author zhengxin
 * @date 2021/3/9
 */
public class Google {

    public static final BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 1500, 0.01);

    public static void main(String[] args) {

        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }
}
