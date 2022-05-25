package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;


/**
 * Object of the first screen that appears when we open the application.
 */

public class TutorialScreen extends BaseScreen {

    /**
     * Constructor method.
     * @param driver the driver
     */
    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "permission_primary_btn")
    private AndroidElement getStartedButton;

    @AndroidFindBy(id = "permission_primary_btn")
    private AndroidElement shareLocationButton;

    @AndroidFindBy(id = "button1")
    private AndroidElement allowLocationButton;

    @AndroidFindBy(id = "permission_allow_foreground_only_button")
    private AndroidElement allowButton;

//    @AndroidFindBy(id = "button2")
//    private AndroidElement importantUpdate;

    /**
     * Start permissions process.
     */
    public void startPermissionsProcess() {
        click(getStartedButton);
    }

    /**
     * Share Location permissions process.
     */
    public DashBoardScreen shareLocationPermissions() {
        click(shareLocationButton);
        click(allowLocationButton);
        click(allowButton);
        return new DashBoardScreen(driver);
    }

//    public DashBoardScreen importantUpdateOK(){
//        click(importantUpdate);
//        return new DashBoardScreen(driver);

//    }
}
