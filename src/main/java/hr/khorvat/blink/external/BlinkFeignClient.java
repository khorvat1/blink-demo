package hr.khorvat.blink.external;

import hr.khorvat.blink.config.external.BlinkFeignClientConfig;
import hr.khorvat.blink.model.dto.BlinkRequestDTO;
import hr.khorvat.blink.model.dto.BlinkResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "blink", url = "https://api.microblink.com", configuration = BlinkFeignClientConfig.class)
public interface BlinkFeignClient {

    @PostMapping(value = "/recognize/execute")
    ResponseEntity<BlinkResponseDTO> request(@RequestBody BlinkRequestDTO request);
}
