package com.myecom.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.myecom.base.BaseClass;

public class UtilityP extends BaseClass
{
public static String getScreenShot(WebDriver driver,String name) throws Exception
{
	File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMDDhhmmss"));
	String desc=projectPath+"screenshots//"+name+currentTime+" .png";
	File destinationFile=new File(desc);
	FileUtils.copyFile(sourceFile, destinationFile);
	return desc;
	
}
}
