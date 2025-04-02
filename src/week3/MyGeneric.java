package week3;

public class MyGeneric<T> {
    private T value;
    MyGeneric(){}
    MyGeneric(T value){
        this.value = value;
    }
    T getValue(){
        return value;
    }
    void setValue(T value){
        this.value = value;
    }

    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj =  new MyGeneric<>();

        strObj.setValue("Java");
        intObj.setValue(42);
        System.out.println(strObj.getValue());
        System.out.println(intObj.getValue());
    }
}
