package ru.mkiryanov.banners.rest.model;

/**
 * @author maksim-kiryanov
 */
public class BannersRegisterInfo {
    private String type;
    private Object[] banners;
    private int[] weights;

    public BannersRegisterInfo() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
