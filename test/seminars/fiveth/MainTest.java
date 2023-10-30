package seminars.fiveth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.fiveth.number.MaxNumberModule;
import seminars.fiveth.number.RandomNumberModule;
import seminars.fiveth.order.OrderService;
import seminars.fiveth.order.PaymentService;
import seminars.fiveth.user.UserRepository;
import seminars.fiveth.user.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainTest {
    List<Integer> randomList;
    @BeforeEach
    public void setUp() {
        randomList = Arrays.asList(2,5,9,7,6,1);
    }

    @Test
    public void maxNumberModuleTest() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        int maxValue = maxNumberModule.getMaxValue(randomList);

        Assertions.assertThat(maxValue).isEqualTo(9);
    }

    @Test
    public void randomNumberModuleTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();

        List<Integer> randomList = randomNumberModule.getRandomList(6);

        Assertions.assertThat(randomList).isNotEmpty().hasSize(6);
    }

    @Test
    public void maxRandomTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Integer> randomList = randomNumberModule.getRandomList(6);
        int maxValue = maxNumberModule.getMaxValue(randomList);

        Assertions.assertThat(randomList).isNotEmpty().hasSize(6).contains(maxValue);
        Assertions.assertThat(Collections.max(randomList)).isEqualTo(maxValue);
    }

    @Test
    public void userServiceTest() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String userName = userService.getUserName(5);

        Assertions.assertThat(userName).isEqualTo("User 5");
    }

    @Test
    public void orderPaymentServiceTest() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("ord_15", 15000D);

        Assertions.assertThat(result).isTrue();
    }
}
