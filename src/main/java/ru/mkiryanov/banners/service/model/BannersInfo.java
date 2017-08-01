package ru.mkiryanov.banners.service.model;

/**
 * @author maksim-kiryanov
 */
public class BannersInfo {
    private final Object[] banners;
    private final int[] weights;
    private final int weightSum;

    private BannersInfo(Object[] banners, int[] weights, int weightSum) {
        this.banners = banners;
        this.weights = weights;
        this.weightSum = weightSum;
    }

    public static BannersInfo newBannersInfo(Object[] banners, int[] weights) {
        return new BannersInfo(banners, weights, calcWeightSum(weights));
    }

    private static int calcWeightSum(int[] weights) {
        int tempWeightSum = 0;
        for (int weight : weights) {
            tempWeightSum += weight;
        }
        return tempWeightSum;
    }

    public Object getBanner(int number) {
        return banners.length > number ? banners[number] : null;
    }

    public int getWeight(int number) {
        return weights[number];
    }

    public int getWeightSize() {
        return weights.length;
    }

    public int getWeightSum() {
        return weightSum;
    }
}
