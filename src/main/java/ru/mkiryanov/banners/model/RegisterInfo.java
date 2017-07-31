package ru.mkiryanov.banners.model;

/**
 * @author maksim-kiryanov
 */
public class RegisterInfo {
    private Object[] banners;
    private int[] weights;

    public RegisterInfo() {
    }

    public Object[] getBanners() {
        return banners;
    }

    public void setBanners(Object[] banners) {
        this.banners = banners;
    }

    public int[] getWeights() {
        return weights;
    }

    public void setWeights(int[] weights) {
        this.weights = weights;
    }
}
