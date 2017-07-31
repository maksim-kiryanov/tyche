package ru.mkiryanov.banners.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * @author maksim-kiryanov
 */
@Service
public class BannersService {
    private Object[] banners;
    private int[] weights;
    private int weightSum;
    private Random random;

    @PostConstruct
    public void init() {
        random = new Random();
    }

    public void register(Object[] banners, int[] weights) {
        this.banners = banners;
        this.weights = weights;

        weightSum = 0;
        for (int i = 0; i < weights.length; i++) {
            weightSum += weights[i];
        }
    }

    public Object getRandomBanner() {
        if (banners == null || weights == null) {
            return -1;
        }

        int n = random.nextInt(weightSum) + 1;

        int i = 0;
        for (; i < weights.length; i++) {
            n -= weights[i];
            if (n <= 0) break;
        }

        return banners[i];
    }
}
