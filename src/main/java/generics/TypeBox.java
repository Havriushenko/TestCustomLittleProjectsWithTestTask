package generics;

public class TypeBox <T>{

    T t;

    public TypeBox() {
    }

    public TypeBox(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
