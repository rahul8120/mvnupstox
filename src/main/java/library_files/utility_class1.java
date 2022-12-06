package library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class utility_class1 
{

	
	public static String testingdata(int rowinx, int cellinx) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream	f=new FileInputStream("C:\\Users\\Rahul Jadhav\\Desktop\\Upstox TEST DATA.xlsx");
		 Sheet sh = WorkbookFactory.create(f).getSheet("Login1");
		String d = sh.getRow(rowinx).getCell(cellinx).getStringCellValue();
		return d;
	}
	
	
	
	
	
	
	
	public static void screenshot(WebDriver driver) throws IOException
	{
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String testid = RandomString.make(2);
	File dest=new File("C:\\Users\\Rahul Jadhav\\eclipse-workspace\\mavanProj\\screenshot_mavan\\UP"+testid+".jpg");
	FileHandler.copy(source, dest);
	
	}
	
//property file= only string data..that is sendkeys("") and driver.get(""), kind of data we can store and read, use.
	
	//read string values from properties file= key is string and value is string bydefault in properties file
	public static String impdata1(String key) throws IOException
	{
		FileInputStream	f=new FileInputStream("C:\\Users\\Rahul Jadhav\\eclipse-workspace\\mavanProj\\PropertyFile_mavan.properties");
		Properties file=new Properties(); //like workbookfactory
		file.load(f); //like create() but load() is non static method
		String value = file.getProperty(key); //getproperty()=return type is string...like getstringcellvalue()
		return value;
	}
	
	public static void main(String[] args) throws IOException 
	{
		FileInputStream	f=new FileInputStream("C:\\Users\\Rahul Jadhav\\eclipse-workspace\\selenium1\\upstox_testdata.properties");
		Properties file=new Properties(); //like workbookfactory
		file.load(f); //like create() but load() is non static method
//getProperty(key) vs  get(key) = both are same give null if key doesnt have string
		
// properties class is subclass of hashtable class..i e it contains hashtable methods
		//hashtable methods= get(), entryset()= returns set
		//1. getProperty
				Object value2 = file.get("use"); 
				System.out.println(value2);
		
		//2. get()=return type is object can give null when key doesnt exists or value not stored		
		Object value = file.get("use"); 
		System.out.println(value);
		
		//3.entryset()= method from hashtable class so gives set, get all values from properties file
		
		Set<Entry<Object, Object>> alldata = file.entrySet();
		Iterator<Entry<Object, Object>> itr = alldata.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

		
		//4 keyset()=returns only key...
		//5 for value use..method from hashmap class, 
		
//no need of obj of HashMap as hashmap extends hashtable extends properties 	
		
		//HashMap<String, String> objj=new HashMap<String, String>(); // key= string , value = string
                        Set<Object> ALdata = file.keySet();
                      
                        System.out.println("print key & value by hashmap methods keyset()=keys and get(key) for values");
                        Iterator<Object> itrr = ALdata.iterator();
                        while(itrr.hasNext())
                        {
                        	Object key = itrr.next();
                        	System.out.println("key="+key+" value="+ file.get(key));
                        } //or for each loop we can use
		
}
	
	
	
	
}
