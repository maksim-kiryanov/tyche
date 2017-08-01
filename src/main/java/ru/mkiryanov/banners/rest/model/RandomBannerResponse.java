package ru.mkiryanov.banners.rest.model;

/**
 * @author maksim-kiryanov
 */
public class RandomBannerResponse {
    private Object banner;

    public Object getBanner() {
        return banner;
    }

    private RandomBannerResponse(Object banner) {
        this.banner = banner;
    }

    public static RandomBannerResponse newResponse(Object banner) {
        return new RandomBannerResponse(banner);
    }
}
