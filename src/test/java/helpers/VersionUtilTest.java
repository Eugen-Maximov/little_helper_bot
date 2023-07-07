package helpers;

import org.testng.annotations.Test;

import static helpers.VersionUtil.getApplicationVersion;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class VersionUtilTest {

    @Test(description = "test for VersionUtil")
    public void testCheckGetApplicationVersion() {
        assertThat(
                getApplicationVersion(),
                not(equalTo(null))
        );
    }
}
