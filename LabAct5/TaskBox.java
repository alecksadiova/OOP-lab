package campus.tasks;

public class TaskBox<T> {

    private T item;

    public TaskBox(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
