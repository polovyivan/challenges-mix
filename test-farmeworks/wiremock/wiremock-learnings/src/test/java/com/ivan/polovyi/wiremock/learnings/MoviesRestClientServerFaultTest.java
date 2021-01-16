package com.ivan.polovyi.wiremock.learnings;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.anyUrl;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.serverError;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jenspiegsa.wiremockextension.ConfigureWireMock;
import com.github.jenspiegsa.wiremockextension.InjectServer;
import com.github.jenspiegsa.wiremockextension.WireMockExtension;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.http.Fault;
import com.ivan.polovyi.wiremock.learnings.dto.Movie;
import com.ivan.polovyi.wiremock.learnings.exception.MovieErrorResponse;
import com.ivan.polovyi.wiremock.learnings.service.MoviesRestClient;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@ExtendWith(WireMockExtension.class)
public class MoviesRestClientServerFaultTest {


  private MoviesRestClient moviesRestClient;
  private WebClient webClient;

  @InjectServer
  private WireMockServer wireMockServer;

  TcpClient tcpClient = TcpClient.create()
      .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
      .doOnConnected(connection -> {
        connection.addHandlerLast(new ReadTimeoutHandler(5))
            .addHandlerLast(new WriteTimeoutHandler(5));
      });

  @ConfigureWireMock
  private Options options = wireMockConfig()
      .port(8088)
      .notifier(new ConsoleNotifier(true))
      .extensions(new ResponseTemplateTransformer(true));


  @BeforeEach
  void setUp() {
    int port = wireMockServer.port();
    String baseUrl = String.format("http://localhost:%s", port);
    System.out.println("baseUrl = " + baseUrl);
    //webClient = WebClient.create(baseUrl);
    webClient = WebClient.builder()
        .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
        .baseUrl(baseUrl).build();

    moviesRestClient = new MoviesRestClient(webClient);
  }

  @Test
  public void retrieveAllMovies() {
    //given
    stubFor(get(anyUrl())
        .willReturn(serverError()));

    //then
    assertThrows(MovieErrorResponse.class, () -> moviesRestClient.retrieveAllMovies());

  }

  @Test
  public void retrieveAllMoviesServiceUnavailable503() {
    //given
    stubFor(get(anyUrl())
        .willReturn(serverError()
            .withStatus(HttpStatus.SERVICE_UNAVAILABLE.value())
            .withBody("Service Unavailable")));

    //then
    assertThrows(MovieErrorResponse.class, () -> moviesRestClient.retrieveAllMovies());
  }

  @Test
  public void retrieveAllMoviesFaultResponse() {
    //given
    stubFor(get(anyUrl())
        .willReturn(aResponse().withFault(Fault.EMPTY_RESPONSE)));

    //then
    MovieErrorResponse movieErrorResponse = assertThrows(MovieErrorResponse.class,
        () -> moviesRestClient.retrieveAllMovies());
  }

  @Test
  public void retrieveAllMoviesRandomDateThenClose() {
    //given
    stubFor(get(anyUrl())
        .willReturn(aResponse().withFault(Fault.RANDOM_DATA_THEN_CLOSE)));

    //then
    MovieErrorResponse movieErrorResponse = assertThrows(MovieErrorResponse.class,
        () -> moviesRestClient.retrieveAllMovies());
  }

  @Test
  public void retrieveAllMoviesFixedDelay() {
    //given
    stubFor(get(anyUrl())
        .willReturn(ok().withFixedDelay(10000)));

    //then
    assertThrows(MovieErrorResponse.class,
        () -> moviesRestClient.retrieveAllMovies());
  }

  @Test
  public void retrieveAllMoviesRandomDelay() {
    //given
    stubFor(get(anyUrl())
        .willReturn(ok().withUniformRandomDelay(60000,10000)));

    //then
    assertThrows(MovieErrorResponse.class,
        () -> moviesRestClient.retrieveAllMovies());
  }
}
