package com.vamtester.utils;

import com.vamtester.Model.UserNameAndPassword;
import io.reactivex.rxjava3.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Base {

    public String USER_DIR = System.getProperty("user.dir");

    public WebDriver setUp(@NonNull String url)
    {
        System.out.println("============================================================");
        System.out.println("                    Chrome Launched                         ");
      //  System.setProperty("webdriver.chrome.driver", USER_DIR+"/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        System.out.println("=============================================================");
        return driver;
    }

    public void tearDown(@NonNull WebDriver driver)
    {
        driver.quit();
    }

    public UserNameAndPassword getCredentials(@NonNull WebDriver driver)
    {
        System.out.println("============================================================");
        System.out.println("                    Credentials Fetched                    ");
       List<Object> g = new ArrayList<>();
               driver.findElements(By.cssSelector("#login ul li b"))
                        .stream()
                                .forEach(e -> g.add(e.getText().trim()));
        System.out.println("============================================================");
        System.out.println(g);
        UserNameAndPassword up = new UserNameAndPassword(g.get(0).toString(), g.get(1).toString());
        return up;

    }


}
