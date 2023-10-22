package seminars.fourth.database;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class DataProcessorTest {

    @Test
    public void testDatabase() {
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        when(database.query(anyString())).thenReturn(Arrays.asList("Str1", "Str2", "Str3"));
        List<String> strings = dataProcessor.processData("select...");
        verify(database, times(1)).query("select...");
        Assertions.assertThat(strings)
                .isNotEmpty()
                .hasSize(3)
                .isEqualTo(Arrays.asList("Str1", "Str2", "Str3"));
    }
}