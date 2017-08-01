package ru.mkiryanov.banners.service;

import org.springframework.stereotype.Service;
import ru.mkiryanov.banners.service.model.BannersInfo;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

import static ru.mkiryanov.banners.service.model.BannersInfo.newBannersInfo;

/**
 * @author maksim-kiryanov
 */
@Service
public class BannersService {
    private Map<String, BannersInfo> bannerInfos;

    @PostConstruct
    public void init() {
        bannerInfos = new ConcurrentHashMap<>();
    }

    public void register(String type, Object[] banners, int[] weights) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type should be not empty string");
        }

        if (banners == null || banners.length == 0) {
            throw new IllegalArgumentException("Banners should be not empty");
        }

        if (weights == null || weights.length == 0) {
            throw new IllegalArgumentException("Weights should be not empty");
        }

        if (banners.length != weights.length) {
            throw new IllegalArgumentException("Weights should be correspond to banners");
        }

        bannerInfos.put(type, newBannersInfo(banners, weights));
    }

    public Object getRandomBanner(String type) {
        BannersInfo bannersInfo = bannerInfos.get(type);
        if (bannersInfo == null) {
            throw new IllegalStateException(String.format("Not found banners for type '%s'", type));
        }

        int n = ThreadLocalRandom.current().nextInt(bannersInfo.getWeightSum()) + 1;

        int i = 0;
        for (; i < bannersInfo.getWeightSize(); i++) {
            n -= bannersInfo.getWeight(i);
            if (n <= 0) break;
        }

        return bannersInfo.getBanner(i);
    }
}
