import org.junit.Test;

import java.util.Random;

/**
 * Created by j0 on 2016/8/4.
 */
public class RandomTest {


    @Test
    public void testRandom() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        System.out.print(result);
    }
}
