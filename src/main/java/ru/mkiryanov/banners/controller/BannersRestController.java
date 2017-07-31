package ru.mkiryanov.banners.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.mkiryanov.banners.model.RegisterInfo;
import ru.mkiryanov.banners.service.BannersService;

/**
 * @author maksim-kiryanov
 */
@RestController
@RequestMapping("/banners")
public class BannersRestController {
    @Autowired
    private BannersService bannersService;

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<?> registerBanners(@RequestBody RegisterInfo registerInfo) {
        bannersService.register(registerInfo.getBanners(), registerInfo.getWeights());

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/random")
    public Object getRandomBanner() {
        return bannersService.getRandomBanner();
    }
}
