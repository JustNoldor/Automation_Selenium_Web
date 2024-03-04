
# Selenium Web Automation Project

This project is created to run automation tests for the [Binance](https://binance.com/) website. In this README file, you can find the project structure, tech stack and steps to execute test scenarios.

## Tech Stack

Java, Selenium, Cucumber, WebDriverManager
  
## Selenium Grid

To run the selenium standalone at the location where the jar file under "requirements" is located, the following command is used. (Giving a timeout here is not mandatory, but it will be functional to prevent sessions from remaining open in the background due to potential errors that may occur.)

```bash
  java -jar selenium-server-4.15.0.jar standalone --session-timeout 60
```

Nodes can be created with different ports according to the need for the number of nodes.
```bash
  java -jar selenium-server-4.15.0.jar node --port 5555
```

We can access the Selenium Grid interface where we can see session and node information via the URL shared below.

```bash
  http://localhost:4444/
```

## How to Run?


To install the dependencies in the project;

```bash
  mvn clean install
```
To run all the tests in the project;
```bash
  mvn test
```
To run scenarios with specific tags;
```bash
  mvn test  -Dcucumber.filter.tags="@Case1"
```


## How to Write Tests?

It would be better to look at the structure of the project in tree format to understand the structure of the project.

In this automation project written using Page Object Model, we create our modeled objects under "pages". For example, if the "MarketPage" page is to be modeled, we add it separately under "pages > page". However, if there is a common model, we move it to the "common" folder. As a common model, you can think of a menu in the header, for example.


```bash
└── src
    └── test
        └── java
            ├── pages
            │   ├── common
            │   │   ├── CookieObject.java
            │   │   ├── FooterObject.java
            │   │   └── MenuObject.java
            │   └── page
            │       ├── CoinDetailPage.java
            │       ├── HomePageObject.java
            │       ├── LoginPageObject.java
            │       └── MarketPageObject.java
            └── stepdefs
                ├── common
                │   ├── CookieStepDef.java
                │   ├── FooterStepDef.java
                │   └── MenuStepDef.java
                └── page
                    ├── CoinDetailPageStepDef.java
                    ├── HomePageStepDef.java
                    ├── LoginPageStepDef.java
                    └── MarketPageStepDef.java
```

### Step Definition Structure
As noticed from the tree structure, each Step Definition file has a corresponding PageObject file. The approach we take here is to keep Step Definition files cleaner. For this, there are two different approaches in step definition files.

The first one is to access the PageObject file and take a specific action;
```bash
    @When("I login invalid credentials")
    public void loginInvalidCredentials() {
        loginpageObject.loginInvalidCredentials();
    }
```

The second one is to use Assert to verify the data in the method called from the PageObject file;
```bash
    public void verifyErrorMessage() {
        Assert.assertEquals(dataProperty.getLoginErrorMessage(),loginpageObject.getLoginErrorText());
    }
```

### PageObject Structure
In PageObject files, we create a WebElement with a selector for the area we want to model as shown in the code block below.
```bash
    @FindBy(css = "form")
    WebElement Login;
```
Then, we model the relevant page with PageFactory and return the page's part with the selected selector as a model.
```bash
    WebElement LoginForm(){
        PageFactory.initElements(driver,this);
        return Login;
    }
```
Finally, as in the example below, we can perform the relevant operations through this method we return.
```bash
   public void loginInvalidCredentials(){
        LoginForm().findElement(By.id("username")).sendKeys("mostwrongestemailintheworld12@mail.com");
        LoginForm().findElement(By.id("click_login_submit_v2")).click();
    }
```

### Note
 According to the Page Object Model structure, validation (Assert) operations should not be performed in PageObject files. All of these should be in Step Definition files. This is the appropriate approach for clean code and to prevent irrelevant Assert operations from being repeated each time the object is called.
