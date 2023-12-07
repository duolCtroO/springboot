package OortCloud.springboot;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

    @Test
    void controllerTest(){
        HelloBootController controller = new HelloBootController(name -> name);

        Assertions.assertThat(controller.hello("boot")).isEqualTo("boot");

        Assertions.assertThatThrownBy(() -> {
            controller.hello(null);
        }).isInstanceOf(NullPointerException.class);

        Assertions.assertThatThrownBy(() -> {
            controller.hello("");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
