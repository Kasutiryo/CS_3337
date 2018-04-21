# Java Web Application Starter with Gradle

This is the starter set to start Java application development with Gradle using
Gretty.

## Runtime dependencies

You will need Java & Gradle to run this project. It might be possible to test the site without installing Gradle. However if you
do, follow these steps: https://gradle.org/install/ 

## Get Started

Download and unzip the entire repository. Open your terminal whether it be Git, CMD, Powershell, etc, and navigate to 
the same directory where you unziped the repository. Type in `./gradlew build` to get unpack any dependencies.

You can run `./script/start.sh` or `/gradlew appRun` to start application and go to `http://localhost:8080/{HTML_PATH}`

You can start adding more Java Servlets under `src/main/java` folder to continue
hacking!

## Development

In brief, there are two side of story in this project: **front end development**
and **back end development**.

### File Structure

```
src/main/
	/java/                  -> Your java classes
	/webapp/                -> Your front end resources
		js/                 -> JavaScript assets
build.gradle                    -> necessary gradle definition
build/                          -> built files
	classes                     -> compiled java classes
```
