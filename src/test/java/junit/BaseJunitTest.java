package junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseJunitTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Before Test");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After Test");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }
}
