package asia.powerbiz.utils.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
@Slf4j
public class TelegramLogUtil {
    private final HttpClient client;
    private String telegramUrl;
    private String botToken;
    private String chatId;
    private String telegramPath;
    private String appName;


    TelegramLogUtil(@Value("${app.monitoring.telegram.url}") String telegramUrl,
                    @Value("${app.monitoring.telegram.chat-id}") String chatId,
                    @Value("${spring.application.name}") String appName,
                    @Value("${app.monitoring.telegram.bot-token}") String botToken){ /*
        this.telegramPath = "/{token}/sendMessage";*/
        this.telegramPath = "/{token}/sendMessage";
        this.telegramUrl = telegramUrl;
        this.chatId = chatId;
        this.appName = appName;
        this.botToken = botToken;
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2)
                .build();

    }

    public void sendLog(String message){
        try{
            _sendLog(message);
        } catch (Exception e){
            log.error("TelegramLogUtil:: sendLog error: {}", e.getMessage());
        }
    }


    private void _sendLog(String message) throws IOException, InterruptedException {
        String textMessage = String.format("%s:: %s", appName, message);
        UriBuilder uriBuilder = UriComponentsBuilder.fromUri(URI.create(telegramUrl))
                .path(telegramPath)
                .queryParam("chat_id", chatId)
                .queryParam("text", textMessage);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(uriBuilder.build("bot" + botToken))
                .timeout(Duration.ofSeconds(5))
                .build();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}