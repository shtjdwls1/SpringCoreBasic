package hello.core.singleton;

public class SingletonService {
    // 싱글톤 패턴을 구현하는  여러방법중 객체를 미리 생성해두는 가장 안전한 방법 사용
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
