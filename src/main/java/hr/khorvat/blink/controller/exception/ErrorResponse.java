package hr.khorvat.blink.controller.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
public class ErrorResponse implements Serializable {

    private final String message;
    private final String logref;
}
