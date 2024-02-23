package hasanalmuDev.Belajarjavareflection;

public class Data<T extends AutoCloseable, E, R ,H> {

    private T date;

    public Data(T date) {
        this.date = date;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
