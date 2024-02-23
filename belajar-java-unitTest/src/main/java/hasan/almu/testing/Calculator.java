package hasan.almu.testing;

public class Calculator {

    public Integer Add(int first, int second) {
        return  first + second;
    }

    public Integer devide(int first, int second) {
        if(second == 0) {
            return 0;
        }
        return first / second;
    }

    public  Integer multipctin(int first, int second) {
        return  first * second;
    }


}
