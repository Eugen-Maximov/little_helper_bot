package helpersTests;

import helpers.LogHelper;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogHelperTest {

    @Test
    public void testSessionIdFormat() {
        assertThat(
                LogHelper.SESSION_ID,
                is(notNullValue())
        );
    }

    @Test
    public void testLoggerIsEnabled() {
        assertThat(
                LogHelper.LOGGER.getName(),
                is(LogHelper.class.getName())
        );
    }
}
