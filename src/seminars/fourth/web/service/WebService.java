package seminars.fourth.web.service;

public class WebService {
    private final HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    public void getHttp(String url) {
        System.out.println(httpClient.get(url));
    }
}
