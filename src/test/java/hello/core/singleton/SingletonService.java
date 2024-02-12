package hello.core.singleton;

import java.security.Signature;

public class SingletonService {

    //자기자신을 static으로 하나만 존재하게
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
