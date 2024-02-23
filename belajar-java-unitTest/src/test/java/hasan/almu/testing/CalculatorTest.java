package hasan.almu.testing;

import hasan.almu.testing.generator.SimpleDisplayGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@DisplayName("Calculator test by junit")

@DisplayNameGeneration(SimpleDisplayGenerator.class) //untuk merubah nama sesuai class dan method

@Tag("Condition-Test")
public class CalculatorTest {

    private  Calculator calcu = new Calculator();

//    BEFORE AND AFTER
    @BeforeAll
    public static void beforeAll(){
        System.out.println("before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    public  void beforeEach() {
        System.out.println("Before testing");
    }
    @AfterEach
    public void afterEach() {
        System.out.println("After testing");
    }

    @Test
//    @DisplayName("Test add method")
    public void testCalcuAdd() {
        var result = calcu.Add(12,8);
        assertEquals(20,result);
    }

    @Test
//    @DisplayName("Test multi method")
    public void testCalcuMulti() {
        var result = calcu.multipctin(12,2);
        assertEquals(24,result);
    }

//    MENUNDA TESTING MENGGUNAKAN DISABLE
    @Test
    @Disabled
//    @DisplayName("Test devide method")
    public void testCalcuDevide() {
       assertThrows(IllegalArgumentException.class, () -> {
           calcu.devide(12,1);
       });
    }

    @Test
    @Disabled
    public void testAntengSoon() {}


//     MEMBATALKAN TESTING MENGGUNAKAN ASUMSI
    @Test
    public void testAbsorted() {
        var profile = System.getenv("HASAN");
        if(!"DEPOL".equals(profile)) {
            throw new TestAbortedException("Test di batalkan karena bukan dev");
        }
    }

    @Test
    public void testAbsorted2() {
        assumeTrue("DEPOL".equals(System.getenv("HASAN")));
    }


}
