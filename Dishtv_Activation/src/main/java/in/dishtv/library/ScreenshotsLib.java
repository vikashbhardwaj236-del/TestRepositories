package in.dishtv.library;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.google.common.io.Files;

public class ScreenshotsLib {
                public static String PATH;
                

                public static void getScreenshot(WebDriver driver, String foldername, String filename) {
                                String StrDt = Fun_DateTime();
                                PATH = "\\screenshots\\" + foldername + "\\";
                                EventFiringWebDriver efw = new EventFiringWebDriver(driver);
                                File scrfile = efw.getScreenshotAs(OutputType.FILE);
                                try {
                                                Files.copy(scrfile, new File(System.getProperty("user.dir") + PATH + filename.toUpperCase()+"-"+StrDt + ".png"));
                                } catch (IOException e) {
                                                Reporter.log(e.getLocalizedMessage(), true);
                                }
                }

                /// Function to get Current & Time
                public static String Fun_DateTime() {
                                DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy 'at' hh-mm-ss a zzz");
                                Date date = new Date();
                                String Str_Date = dateFormat.format(date);
                                return Str_Date;
                }

}
