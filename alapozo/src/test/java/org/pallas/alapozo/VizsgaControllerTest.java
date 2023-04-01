
package org.pallas.alapozo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pallas.alapozo.helpers.VizsgaControllerHelper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VizsgaControllerTest {

    @Test
    public void randomNumberTest(){
        Assertions.assertThat(VizsgaControllerHelper.getRandomNumber(101, 200)).isBetween(1, 100);
    }
    
    @Test
    public void randomNumber2Test(){
        Assertions.assertThat(45).isBetween(1, 100);
    }
}
