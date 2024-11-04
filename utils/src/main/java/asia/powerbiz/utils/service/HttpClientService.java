package asia.powerbiz.utils.service;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpClientService {

    private WebClient client;

    public Mono<String> invokeGet(String baseUrl, String pathUrl, Map<String, Object> params, Map<String,String> headerKeys){
        String url = buildReqParam(pathUrl, params);
        initClient(baseUrl);
        return client.get()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.addAll(buildHeaders(headerKeys)))
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .onErrorResume(throwable -> Mono.error(new RuntimeException("err")))
                        .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody))))
                .bodyToMono(String.class);
    }

    public Mono<String> invokePost(String baseUrl, String pathUrl, Map<String, Object> params, Object requestBody, Map<String,String> headerKeys){
        String url = buildReqParam(pathUrl, params);
        initClient(baseUrl);

        return client.post()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.addAll(buildHeaders(headerKeys)))
                .bodyValue(requestBody)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .onErrorResume(throwable -> Mono.error(new RuntimeException("err")))
                        .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody))))
//                .onStatus(HttpStatusCode::isError,
//                        clientResponse -> clientResponse.bodyToMono(IllegalStateException.class)
//                                                        .handle((error, sink)-> sink.error(new IllegalStateException(error))))
                .bodyToMono(String.class);
    }

    public Mono<byte[]> invokePostToByte(String baseUrl, String pathUrl, Map<String, Object> params, Object requestBody, Map<String,String> headerKeys){
        String url = buildReqParam(pathUrl, params);
        initClient(baseUrl);

        return client.post()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.addAll(buildHeaders(headerKeys)))
                .bodyValue(requestBody)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .onErrorResume(throwable -> Mono.error(new RuntimeException("err")))
                        .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody))))
//                .onStatus(HttpStatusCode::isError,
//                        clientResponse -> clientResponse.bodyToMono(IllegalStateException.class)
//                                                        .handle((error, sink)-> sink.error(new IllegalStateException(error))))
                .bodyToMono(byte[].class);
    }


    public Mono<String> invokePut(String baseUrl, String pathUrl, Map<String, Object> params, Object requestBody, Map<String,String> headerKeys){
        String url = buildReqParam(pathUrl, params);
        initClient(baseUrl);

        return client.put()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.addAll(buildHeaders(headerKeys)))
                .bodyValue(requestBody)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .onErrorResume(throwable -> Mono.error(new RuntimeException("err")))
                        .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody))))
//                .onStatus(HttpStatusCode::isError,
//                        clientResponse -> clientResponse.bodyToMono(IllegalStateException.class)
//                                                        .handle((error, sink)-> sink.error(new IllegalStateException(error))))
                .bodyToMono(String.class);
    }


    public Mono<String> invokeDelete(String baseUrl, String pathUrl, Map<String,String> headerKeys){
        initClient(baseUrl);
        return client.delete()
                .uri(pathUrl)
                .headers(httpHeaders -> httpHeaders.addAll(buildHeaders(headerKeys)))
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .onErrorResume(throwable -> Mono.error(new RuntimeException("err")))
                        .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody))))
                .bodyToMono(String.class);
    }


    public Mono<String> invokeMultiPartPost(String baseUrl, String pathUrl, MultipartBodyBuilder requestBody, Map<String,String> headerKeys){
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(50000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(45000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(45000, TimeUnit.MILLISECONDS)));
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE)
                .build();

        return client.post()
                .uri(pathUrl)
                .headers(httpHeaders -> httpHeaders.addAll(buildHeaders(headerKeys)))
                .body(BodyInserters.fromMultipartData(requestBody.build()))
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .onErrorResume(throwable -> Mono.error(new RuntimeException("err")))
                        .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody))))
                .bodyToMono(String.class);
    }


    private void initClient(String baseUrl){
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 45000)
                .responseTimeout(Duration.ofMillis(50000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(50000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(50000, TimeUnit.MILLISECONDS)));
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();

    }

    protected String buildReqParam(String url, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder(url);
        sb.append("?");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return sb.toString();
    }

    protected HttpHeaders buildHeaders(Map<String, String> headerValues){
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, String> entry : headerValues.entrySet()){
            httpHeaders.add(entry.getKey(), entry.getValue());
        }
        return  httpHeaders;
    }

}
