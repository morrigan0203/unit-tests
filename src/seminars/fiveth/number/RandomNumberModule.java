package seminars.fiveth.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {

    public List<Integer> getRandomList(int count) {
        Random r = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int i=0; i<count; i++) {
            randomList.add(r.nextInt(10));
        }
        return randomList;
    }
}
