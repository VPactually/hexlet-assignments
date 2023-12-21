package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        var list = List.of(1,2,3,4,5,6,7,8);

        assertThat(App.take(list, 0)).isEqualTo(List.of());
        assertThat(App.take(list, 2)).isEqualTo(List.of(1,2));
        assertThat(App.take(list, 100)).isEqualTo(list);

        // END
    }
}
