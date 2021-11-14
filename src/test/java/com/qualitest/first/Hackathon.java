package com.qualitest.first;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Hackathon {

	public WebDriver driver;

	@BeforeSuite
	public void initialisation(){
		System.setProperty("webdriver.chrome.driver", "C:\\browserdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://54.80.137.197:5000/");
	}
	
	@Test
	public void Step00_enterIntoGateAndStart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body > div > div > div > div > a:nth-child(6) > img")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#start")).click();
	}
	
	@Test(dependsOnMethods = "Step00_enterIntoGateAndStart")
	public void Step01_proceedBtnTest(){
		for(int i=1; i<=5; i++){
			driver.findElement(By.cssSelector("#c1submitbutton"+Integer.valueOf(i))).click();
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.equals("http://54.80.137.197:5000/c/a_video")){
				break;
			}
		}
	}

	@Test(dependsOnMethods = "Step01_proceedBtnTest")
	public void Step02_playVideo() throws InterruptedException {
		driver.findElement(By.cssSelector("#aVideoPlayer")).click();
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("#aVideoPlayer")).sendKeys("k");
//		ChromeOptions chrome_options = new ChromeOptions();
//		chrome_options = driver.ChromeOptions();
//		chrome_options.add_argument("--mute-audio");
//		driver.mute();

//		ChromeOptions op = new ChromeOptions();
//		op.addArguments("−−mute−audio");
//		driver.ChromeDriver(op);
//		video = driver.findElement(By.cssSelector("#aVideoPlayer"));
//		driver.execute_script("arguments[0].muted = true;", video)

//		WebElement elm = driver.findElement(By.id("video_iframe"));
//		String urlStr = elm.getAttribute("src");
//		System.out.println("Video Url : " + urlStr);
//		driver.navigate().to(urlStr);
//		cdrv.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//Click on play button
//		jse.executeScript("jwplayer().play();");
//		Thread.sleep(2000);
//Pause
//		jse.executeScript("jwplayer().pause()");
//		Thread.sleep(2000);
//Play
//		jse.executeScript("jwplayer().play();");
//		Thread.sleep(2000);
//// Set Volume
//		Thread.sleep(2000);
//		jse.executeScript("jwplayer().setVolume(50);");
//		Thread.sleep(2000);
////Mute Player
//		jse.executeScript("jwplayer().setMute(true);");
//		Thread.sleep(2000);
////UnMute Player
//		jse.executeScript("jwplayer().setMute(false);");
//		Thread.sleep(2000);
//Stop the player
//		jse.executeScript("jwplayer().stop()");
//		Thread.sleep(2000);

//		driver = driver.Chrome(chrome_options=chrome_options);
	}
}
