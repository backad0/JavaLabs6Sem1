package Task10;

public class Pair<T, T1> {
    private T value0;
    private T1 value1;

    public Pair(T value0, T1 value1){
        this.value0 = value0;
        this.value1 = value1;
    }

    public T getValue0() {
        return value0;
    }

    public T1 getValue1() {
        return value1;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value0=" + value0 +
                ", value1=" + value1 +
                '}';
    }
}
