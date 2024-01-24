package practice;


import java.nio.file.Paths;

import com.microsoft.playwright.*;
public class App {
	
	
	//with headless
	public void launchAppWithHeadless() {
		try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
            browser.close();
        }
	}
	
	//without headless and with slowmotion time
	public void launchAppWithoutHeadless() {
		try {
			Playwright playwright = Playwright.create();
			  Browser browser =	playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
			Page page=  browser.newPage();
			page.navigate("http://playwright.dev");
			System.out.println(page.title());
			browser.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//take screenshot
	public void takeScreenshot() {
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.webkit().launch();
		      Page page = browser.newPage();
		      page.navigate("https://playwright.dev/");
		      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		    }
	}
	
    public static void main(String[] args) {
    	App app = new App();
    	app.launchAppWithoutHeadless();
    	app.launchAppWithHeadless();
    	app.takeScreenshot();
    }
}