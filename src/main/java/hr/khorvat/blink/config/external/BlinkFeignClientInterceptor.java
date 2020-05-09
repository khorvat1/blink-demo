package hr.khorvat.blink.config.external;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class BlinkFeignClientInterceptor implements RequestInterceptor {

    private final String authorizationValue;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + authorizationValue);
    }
}
