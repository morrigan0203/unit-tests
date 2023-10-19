package seminars.third;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

public class LengtherTest {

    @Test
    public void testGetLength() {
        Lengther lengther = new Lengther();

        double result = lengther.getLength(20);

        Assertions.assertThat(result).isEqualTo(62.83185307179586, Offset.offset(0.0001));
    }
}
