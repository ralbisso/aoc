package utils;

public class Cup {

    int value = 0;
    Cup next = null;

    public Cup(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Cup getNext() {
        return next;
    }

    public void setNext(Cup next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[Cup n°" + this.value + ", next one is n°" + this.next.getValue() + "]";
    }
}
