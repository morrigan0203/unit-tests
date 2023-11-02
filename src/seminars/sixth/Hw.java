package seminars.sixth;

import java.util.List;

public class Hw {

    private final List<Integer> first;
    private final List<Integer> second;

    public Hw(List<Integer> first, List<Integer> second) {
        this.first = first;
        this.second = second;
    }

    public double avgFirst() {
        if (this.first == null) {
            throw new IllegalArgumentException("Список должен быть не Null");
        }
        if (this.first.isEmpty()) {
            return 0D;
        }
        Integer sum = 0;
        for(Integer num: this.first) {
            sum += num;
        }
        return sum/this.first.size();
    }

    public double avgSecond() {
        if (this.second == null) {
            throw new IllegalArgumentException("Список должен быть не Null");
        }
        if (this.second.isEmpty()) {
            return 0D;
        }
        Integer sum = 0;
        for(Integer num: this.second) {
            sum += num;
        }
        return sum/this.second.size();
    }

    public String getCompareMessage() {
        int i = Double.compare(avgFirst(), avgSecond());
        if (i < 0) {
            return "Второй список имеет большее среднее значание";
        } else if (i > 0) {
            return "Первый список имеет большее среднее значание";
        }
        return "Средние значание равны";
    }
}
