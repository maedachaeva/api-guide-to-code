package com.demo.statistics.external.holiday;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;

@Slf4j
@Component
public class HolidayClient {
    private final WebClient webClient;
    private final String serviceKey;

    public HolidayClient(
            WebClient.Builder webClientBuilder,
            @Value("${holiday.api.base-url}") String baseUrl,
            @Value("${holiday.api.service-key}") String serviceKey
    ) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
        this.serviceKey = serviceKey;
    }

    public String fetchHolidayXml(int year, int month) {
        URI uri = UriComponentsBuilder
                .fromPath("/getRestDeInfo")
                .queryParam("ServiceKey", serviceKey)
                .queryParam("solYear", year)
                .queryParam("solMonth", String.format("%02d", month))
                .queryParam("numOfRows", 100)
                .queryParam("pageNo", 1)
                .build(true)
                .toUri();

        log.info("공휴일 API 호출 시작 - year={}, month={}", year, month);

        return webClient.get()
                .uri(uri)
                .retrieve()
                .onStatus(HttpStatusCode::isError, res ->
                        res.bodyToMono(String.class)
                                .defaultIfEmpty("")
                                .flatMap(body -> {
                                    log.error("Holiday API 호출 실패 - status={}, body={}", res.statusCode(), body);

                                    // TODO: ErrorCode 정의 후 BusinessException 적용
                                    // TODO: 4xx / 5xx 에러 분리 처리
                                    return Mono.error(
                                            new IllegalStateException("Holiday API error: " + res.statusCode())
                                    );
                                })
                )
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(5))
                .block();
    }
}
