package util.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import screens.DashBoardScreen;
import screens.TutorialScreen;
import util.ConfigCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Base class for Test classes.
 */
public abstract class BaseMobileTest {

    protected TutorialScreen tutorialScreen;
    public static AndroidDriver<AndroidElement> driver;
    public Logger log = Logger.getLogger(BaseMobileTest.class);

    public void setUpStartApp() {
        tutorialScreen = new TutorialScreen(getDriver());
    }

    /**
     * SetUp before to run suite of test.
     */
    @BeforeMethod(alwaysRun = true)
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        setUpStartApp();
    }

    /**
     * Close the application after completing the test.
     */
    @AfterMethod(alwaysRun = true)
    public void mobileApplicationEnd() {
        driver.quit();
    }

    /**
     * return the driver.
     * @return driver
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    /**
     * return SignUpOrLogInScreen after close the alerts.
     * @return SignUpOrLogInScreen
     */
    public DashBoardScreen loadDashBoardScreen() {
        tutorialScreen.startPermissionsProcess();
        return tutorialScreen.shareLocationPermissions();
    }

}
