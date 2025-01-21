package e_bruteforce.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {

    public static void main(String[] args) {

    }


    static void q1(){

    }

    static void q2(){
        // 입력값, 아홉난쟁이 키
        List<Integer> dwarfs = nineDwarfs();

    }

    private static List<Integer> nineDwarfs() {
        List<Integer> dwarfs = new ArrayList<>();
        Random random = new Random();
        int sum = 0;

        for(int i = 0; i < 6; i++){
            int n = random.nextInt(12, 14);
            sum += n;
            dwarfs.add(n);
        }

        dwarfs.add(100 - sum);
        dwarfs.add(random.nextInt(10, 15));
        dwarfs.add(random.nextInt(10, 15));
        return dwarfs;
    }
}
