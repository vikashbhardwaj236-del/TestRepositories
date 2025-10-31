package in.dishtv.library;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Brokenlinks {

	public static void BrokenLinks(WebDriver driver, WebElement PageLink) {
		HttpURLConnection huc = null;
		int respCode = 200;
		String url = "";
		PageLink.click();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			// System.out.println(url);
			if (url == null || url.isEmpty()) {
				System.out.println(url + " >> URL is either not configured for anchor tag or it is empty");
				continue;
			}
			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if (respCode >= 400) {
					System.out.println(url + ">> is a broken link");
				} else {
					// System.out.println(url+" is a valid link");
				}
			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
