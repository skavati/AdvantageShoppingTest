package ibank;

import ibank.pages.Login_Page;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;


import org.apache.log4j.*;

import common.utilities.FileUtils;
import common.utilities.XMLUtils;
import cucumber.api.cli.Main;

public class IBankTestSuite {
	private static final Logger LOGGER = LogManager.getLogger(IBankTestSuite.class);
	public static void main(String[] args) throws Throwable {

		/*LOGGER.info("Security Number: "+System.getProperty(args[0]));
		LOGGER.info("Security Number: "+System.getenv("SecNo"));
		LOGGER.info("Password: "+System.getProperty(args[1]));*/
		// Use below code to provide SecNo and Password from command line during runtime
		// only
		if (args.length > 0) {
			if (args[0].contentEquals("y")) {
				LOGGER.info("*** Using your own credentials ***");
				Login_Page.setUseYourOwnCredentials(true);
				java.io.Console console = System.console();				
				char[] can = console.readPassword("Enter Customer Acesss Number: ");
				String can1 = String.valueOf(can);
				Login_Page.setCan(can1);
				char[] secNo = console.readPassword("Enter Security Number: ");
				String secNum = String.valueOf(secNo);
				Login_Page.setSecNo(secNum);
				// LOGGER.info("Security Number: " + secNum);
				char[] pw = console.readPassword("Enter Password: ");
				String password = String.valueOf(pw);
				Login_Page.setPwd(password);
				// LOGGER.info("Password: " + password);
			}
		}
		// to copy MBResource from JAR file
		copy_IBResource_From_JAR();
		// to create temporary feature list in an order
		setFeatureRunOrderViaPowerShell();
		String configPath = FileUtils.findFullPath(System.getProperty("user.dir"), "config.xml");
		String features = XMLUtils.getNodeText(configPath, "FeatureOrderDir"); // to run project suite
		// final String[] cucumberArgs = { "-g", "mbankweb", "-t", "@Add_payee",
		// features
		// "mbankweb",
		// "classpath:features/Payments/Transfers/Account_details_j2e.feature"
		final String[] cucumberArgs = { "-g", "ibank", "-t", "@smoke",features };
		Main.main(cucumberArgs);
	}

	
	// to copy all resources (IBResource) from JAR file to local directory where JAR
	// file is located
	public static void copy_IBResource_From_JAR() {
		JarFile jarFile = FileUtils.jarForClass(IBankTestSuite.class, null);
		try {
			FileUtils.copyResourcesToDirectory(jarFile, "IBResource", "temp4Auto/resources/IBResource");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("*** IBResource copied from JAR ****: ");
	}

	// @Test
	// to generate list of features to be run in a specfic order using PowerShell
	public static void setFeatureRunOrderViaPowerShell() throws IOException, InterruptedException {
		LOGGER.info("*** START**Copy feature files to temp floder ****: ");
		String file = FileUtils.findFullPath(System.getProperty("user.dir"), "CopyFeatureFilesToTempFolder.ps1");
		String cmd = "powershell.exe -file " + file;
		Runtime.getRuntime().exec(cmd);
		String configPath = FileUtils.findFullPath(System.getProperty("user.dir"), "config.xml");
		String features = XMLUtils.getNodeText(configPath, "FeatureOrderDir"); 
		 File featureOrderDir = new File(features);
		 int i=0;
		 LOGGER.info("Copying feature files in progress...");
		 while (!featureOrderDir.exists() && !featureOrderDir.isDirectory()) {
			 i=i+1;
			 Thread.sleep(1000);
			 if (featureOrderDir.exists() && featureOrderDir.isDirectory()) {
				 LOGGER.info("Feature files copied in "+i+" seconds");
				 break;
			 }
		 }
		LOGGER.info("*** END**Copy feature files to temp floder ****: ");
	}
	
}