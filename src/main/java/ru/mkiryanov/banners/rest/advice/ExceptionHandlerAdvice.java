package ru.mkiryanov.banners.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mkiryanov.banners.rest.model.CommonResponse;

/**
 * @author maksim-kiryanov
 */
@ControllerAdvice(basePackages = "ru.mkiryanov.banners.rest")
public class ExceptionHandlerAdvice {
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<CommonResponse> invalidApiCall(IllegalArgumentException ex) {
        return new ResponseEntity<>(CommonResponse.failed(ex.getMessage()), null,
                HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(IllegalStateException.class)
    ResponseEntity<CommonResponse> notFoundBanners(IllegalStateException ex) {
        return new ResponseEntity<>(CommonResponse.failed(ex.getMessage()), null,
                HttpStatus.NOT_FOUND);
    }
}
