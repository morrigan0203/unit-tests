package seminars.fourth.web.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class WebServiceTest {

    @Test
    public void testHttpRequest() {
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.get(anyString())).thenReturn("Site");
        webService.getHttp("www.site.com");
        verify(httpClient, times(1)).get("www.site.com");
    }
}
