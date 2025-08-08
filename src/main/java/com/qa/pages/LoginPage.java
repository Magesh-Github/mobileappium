package com.qa.pages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.Globalvariables;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.screenrecording.CanRecordScreen;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class LoginPage extends Globalvariables 
{
	AppiumDriver driver;
	String bucketName = "www.elitecorpusa.in";
	String folderName = "WhiteLabel/CommandIQ"; // folder prefix in S3

	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
//		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 30);
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);

	}
	
	public void clickLetGetStartedbtn() throws InterruptedException{
		                     // format;                 // quality level :contentReference[oaicite:1]{index=1}

        ((CanRecordScreen) driver).startRecordingScreen();
        takeScreenshot(driver, "Splash_Screen_screenshot.png");
		letGetStartedBtn.click();
	}
	
	public void enterTheEmailId() throws InterruptedException {
		emailTxtField.sendKeys(null);
	}
	
	public void enterThePassword() throws InterruptedException {
		passwordTxtfield.sendKeys(null);
	}
	
	public void clickLoginBtn() throws InterruptedException, FileNotFoundException, IOException{
		takeScreenshot(driver, "Login_Screen_screenshot.png");
		loginbtn.click();
	}
	
	public void logInWithVaildcrendtails(String email,String password) throws InterruptedException {
		emailTxtField.sendKeys(email);
		passwordTxtfield.sendKeys(password);
	}
	
	public void clickSignUpBtn() throws InterruptedException, FileNotFoundException, IOException {
		signUpBtn.click();
        }
	
	
	public void clickSettingFooter() throws InterruptedException {
		takeScreenshot(driver, "Dashboard_Screen_screenshot.png");
		settingFooter.click();
	}
	
	public void clicklogoutBtn() throws InterruptedException, FileNotFoundException, IOException {
		takeScreenshot(driver, "Settings_Screen_screenshot.png");
		
		takeScreenshot(driver, "Logout_Popup_screenshot.png");
		  // ✅ Stop recording and save the file
        String base64Video = ((CanRecordScreen) driver).stopRecordingScreen();

        byte[] decoded = Base64.getDecoder().decode(base64Video);
        System.out.println("base64Video"+decoded.length);
        try (FileOutputStream fos = new FileOutputStream("ios_simulator_recording.mp4")) {
            fos.write(decoded);
        }
	}
	
	public void navigateToSignUpScr() throws InterruptedException {
		letGetStartedBtn.click();
		signUpBtn.click();
	}
	
	 public static void takeScreenshot(AppiumDriver driver, String baseName) {
	        // Format current timestamp
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

	        // Create unique file name
	        String fileName = baseName + "_" + timestamp + ".png";

	        // Define destination path
	        File destFile = new File(System.getProperty("user.dir") + "/screenshots/" + fileName);

	        try {
	            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            destFile.getParentFile().mkdirs(); // create folder if it doesn't exist
	            FileHandler.copy(srcFile, destFile);
	            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
	        } catch (IOException e) {
	            System.out.println("Error saving screenshot: " + e.getMessage());
	        }
	 }
	        
	        public  void uploadToS3(File file, String bucketName, String folderName) {
	            try {
	                S3Client s3 = S3Client.builder()
	                        .region(Region.US_EAST_1) // ← change to your region
	                        .credentialsProvider(ProfileCredentialsProvider.create())
	                        .build();

	                // 👇 Final object key: folder/filename.mp4
	                String s3Key1 = folderName + "ios" + file.getName();
	                
	                PutObjectRequest putRequest = PutObjectRequest.builder()
	                        .bucket(bucketName)
	                        .key(s3Key1)
	                        .contentType("video/mp4")
	                        .build();

	                s3.putObject(putRequest, Path.of(file.getAbsolutePath()));
	                System.out.println("✅ Uploaded to S3: s3://" + bucketName + "/" + s3Key1);

	            } catch (S3Exception e) {
	                System.err.println("❌ S3 upload failed: " + e.awsErrorDetails().errorMessage());
	            }
	        }
		
	@iOSXCUITFindBy(accessibility = "logout_btn")
	@AndroidFindBy(id="test")
	private WebElement termsAndConditionLink;
	
	@iOSXCUITFindBy(accessibility = "Log out")
	@AndroidFindBy(id="test")
	private WebElement logoutBtn;
	
	@iOSXCUITFindBy(accessibility = "footer_setting")
	@AndroidFindBy(id="test")
	private WebElement settingFooter;
	
	@iOSXCUITFindBy(accessibility = "login_sign_up_txt")
	@AndroidFindBy(id="test")
	private WebElement signUpBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"emailLabel\"]/following-sibling::XCUIElementTypeTextField")
	@AndroidFindBy(id="test")
	private WebElement emailTxtField;
	
	@iOSXCUITFindBy(accessibility = "password_value_txt")
	@AndroidFindBy(id="test")
	private WebElement passwordTxtfield;
	
	@iOSXCUITFindBy(accessibility = "login_btn")
	@AndroidFindBy(id="test")
	private WebElement loginbtn;
	
	@iOSXCUITFindBy(accessibility = "welcomToLabel")
	@AndroidFindBy(id="test")
	private WebElement welcomeTotxt;
	
	@iOSXCUITFindBy(accessibility = "splash_button")
	@AndroidFindBy(id="test")
	private WebElement letGetStartedBtn;
	


}
