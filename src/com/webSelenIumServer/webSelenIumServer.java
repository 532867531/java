//example:http://localhost:8080/seleniumStaticServer/webSelenIumServer?url=http://localhost:8080
package com.webSelenIumServer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Servlet implementation class webSelenIumServer
 */
@WebServlet("/webSelenIumServer")
public class webSelenIumServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebDriver driver = null;
     /**
     * @see HttpServlet#HttpServlet()
     */
    public webSelenIumServer() {
        super();
        // TODO Auto-generated constructor stub
        System.setProperty("webdriver.gecko.driver", "G:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.edge.driver","E:\\MicrosoftWebDriver.exe");
		FirefoxProfile firefoxProfile = new  FirefoxProfile();
//		driver = new FirefoxDriver(firefoxProfile);
//		driver = new HtmlUnitDriver();
		driver = new EdgeDriver();
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String finalurl = request.getParameter("url");
        driver.get(finalurl);
		response.getWriter().append(driver.getPageSource());
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}