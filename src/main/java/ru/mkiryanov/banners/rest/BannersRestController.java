package ru.mkiryanov.banners.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mkiryanov.banners.rest.model.BannersRegisterInfo;
import ru.mkiryanov.banners.rest.model.CommonResponse;
import ru.mkiryanov.banners.rest.model.RandomBannerResponse;
import ru.mkiryanov.banners.service.BannersService;

/**
 * @author maksim-kiryanov
 */
@RestController
@RequestMapping("/banners")
public class BannersRestController {
    private BannersService bannersService;

    @Autowired
    public void setBannersService(BannersService bannersService) {
        this.bannersService = bannersService;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> registerBanners(@RequestBody BannersRegisterInfo info) {
        bannersService.register(info.getType(), info.getBanners(), info.getWeights());

        return ResponseEntity.ok(CommonResponse.success("Banners registered"));
    }

    @RequestMapping(path = "/{type}/random", method = RequestMethod.GET)
    public ResponseEntity<RandomBannerResponse> getRandomBanner(@PathVariable String type) {
        Object banner = bannersService.getRandomBanner(type);
        return ResponseEntity.ok(RandomBannerResponse.newResponse(banner));
    }
}
