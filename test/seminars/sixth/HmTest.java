package seminars.sixth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class HmTest {

    @Test
    public void testAvgFirst() {
        Hw hw = new Hw(Arrays.asList(1,2,3), null);
        Assertions.assertThat(hw.avgFirst()).isEqualTo(2);
    }

    @Test
    public void testAvgFirstEmpty() {
        Hw hw = new Hw(new ArrayList<>(), null);
        Assertions.assertThat(hw.avgFirst()).isEqualTo(0);
    }

    @Test
    public void testAngFirstNegative() {
        Hw hw = new Hw(null, null);
        Assertions.assertThatThrownBy(() -> hw.avgFirst()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testAvgSecond() {
        Hw hw = new Hw(null, Arrays.asList(1,2,3));
        Assertions.assertThat(hw.avgSecond()).isEqualTo(2);
    }

    @Test
    public void testAvgSecondEmpty() {
        Hw hw = new Hw(null, new ArrayList<>());
        Assertions.assertThat(hw.avgSecond()).isEqualTo(0);
    }

    @Test
    public void testAngSecondNegative() {
        Hw hw = new Hw(null, null);
        Assertions.assertThatThrownBy(() -> hw.avgSecond()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCompareFirstLessSecond() {
        Hw hw = new Hw(Arrays.asList(1,2,3), Arrays.asList(2,3,4));
        Assertions.assertThat(hw.getCompareMessage()).isEqualTo("Второй список имеет большее среднее значание");
    }

    @Test
    public void testCompareFirstMoreSecond() {
        Hw hw = new Hw(Arrays.asList(2,3,4), Arrays.asList(1,2,3));
        Assertions.assertThat(hw.getCompareMessage()).isEqualTo("Первый список имеет большее среднее значание");
    }

    @Test
    public void testCompareFirstEqualSecond() {
        Hw hw = new Hw(Arrays.asList(4,3,2), Arrays.asList(2,3,4));
        Assertions.assertThat(hw.getCompareMessage()).isEqualTo("Средние значание равны");
    }

    @Test
    public void testCompareFirstNull() {
        Hw hw = new Hw(null, Arrays.asList(2,3,4));
        Assertions.assertThatThrownBy(() -> hw.getCompareMessage()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCompareSecondNull() {
        Hw hw = new Hw(Arrays.asList(1,2,3), null);
        Assertions.assertThatThrownBy(() -> hw.getCompareMessage()).isInstanceOf(IllegalArgumentException.class);
    }
}
