package ru.mkiryanov.banners.service;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * @author maksim-kiryanov
 */
public class BannersServiceTest {
    private BannersService bannersService;

    @Before
    public void setUp() {
        bannersService = new BannersService();
        bannersService.init();
        bannersService.register(new Object[] {"A", "B", "C"}, new int[] {1, 3, 8});
    }

    @Test
    public void expectBannerCShouldAppearMoreOften() {
        Map<Object, Integer> appears = new HashMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            Object randomBanner = bannersService.getRandomBanner();
            appears.merge(randomBanner, 1, Integer::sum);
        }

        Integer a = appears.get("A");
        Integer b = appears.get("B");
        Integer c = appears.get("C");

        assertThat("'C' appears more often than 'A'", c, greaterThan(a));
        assertThat("'C' appears more often than 'B'", c, greaterThan(b));
        assertThat("'B' appears more often than 'A'", b, greaterThan(a));
    }
}