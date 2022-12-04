# fluegede-test-framework
**Page-Object-Model <br/>**
This automated tests are built for fluege.de app using Selenium libraries, TestNG Unit Testing framework, Integrated with Extent Reports and Java as the programming language. <br/>


**Languages, libraries and tools used <br/>**
Java 8 <br/>
Selenium 4(latest) <br/>
TestNG <br/>
Extent reports <br/>
Eclipse <br/>
Above Features are used to make code simple, generic, understandable, clean and easily maintainable for future development. <br/>

**Automated tests <br/>**
To run a test, open the Project window, and then open src./test/resources folder name and then open testng.xml file and right click to run as TestNG tests. <br/>

To see the reports, open the Project window, and then open the Reports Folder(/test-output/SparkReport) and then double click on Extent.html file or open the Extent.html file on the default browser. <br/>

**Prerequisites <br/>**
Eclipse <br/>
Java <br/>

**Built With <br/>**
Eclipse IDE for Java Developers (includes Incubating components) <br/>
Java 8 - Language used to build the application <br/>

**Running tests in Docker Container with Selenium Grid <br/>**
testng_docker.xml file has the docker configurations. The BaseTest(src/test/java) class has remote webdriver configurations for Selenium Hub

**Prerequisites for running tests in docker <br/>**
1. Docker installed in server/host system <br/>
2. Pulling selenium hub, selenium standalone (Chrome/Firefox) and selenium debug(to view tests in VNC) <br/>
Commands: <br/>
docker pull selenium/hub:3.141.59, docker pull selenium/standalone-chrome,docker pull selenium/node-chrome-debug (same for firefox) <br/>
3. Running the images to have the containers ready (hub and node) <br/>
Commands: <br/>
docker run -d -P -p "4444:4444" --name selenium-hub selenium/hub:3.141.59 <br/>
For Chrome: <br/>
docker run -d -P -p 5900:5900 --link selenium-hub:hub selenium/node-chrome-debug <br/>
docker run -d -p 4445:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome <br/>
For Firefox <br/>
docker run -d -p 4446:4444 -v /dev/shm:/dev/shm selenium/standalone-firefox <br/>
docker run -d -P -p 5901:5900 --link selenium-hub:hub selenium/node-firefox-debug <br/>
4. Opening selenium grid in host/server: http://localhost:4444/grid/console <br/> <br/>
5. Opening VNC Viewer for chrome and firefox (127.0.0.1:5900 - for chrome) and (127.0.0.1:5901 - for firefox) <br/>
