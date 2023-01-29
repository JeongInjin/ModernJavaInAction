package com.me.injin.modernjavainaction.ch03;

//구현된 함수형 인터페이스는 @FunctionalInterface 를 표시하여 검증할 수 있다.
//맞지 않는 경우 에러가 발생(필수 어노테이션은 아님)
@FunctionalInterface
interface Worker {
    void work();
}

public class FITest {
    static void execute(Worker worker) {
        worker.work();
    }

    public static void main(String[] args) {
        //익명 클래스
        execute(new Worker() {
            @Override
            public void work() {
                System.out.println("Hello World");
            }
        });
        //Lambda
        execute(() -> System.out.println("Hello Lambda World"));
    }

    //함수형 인터페이스다.
    public interface Adder {
        int add(int a, int b);
    }

    //SmartAdder 은 두 추상 메서드(Adder 상속 포함)를 포함하므로 함수형 인터페이스가 아님
    public interface SmartAdder extends Adder {
        int add(double a, double b);
    }

    //추상 메서드가 없으므로 함수형 인터페이스가 아님
    public interface Nothing {
    }
}
