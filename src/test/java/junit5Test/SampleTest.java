package junit5Test;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.testFramework.junit5.TestApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestApplication
public class SampleTest {
    @Test
    public void application() {
        assertNotNull(ApplicationManager.getApplication());
    }

    @org.junit.Test
    public void badJunit4Test() {
        assertNotNull(ApplicationManager.getApplication());
    }
}
