# Appium Test Automation Framework

This project is a mobile test automation framework using Appium with Java, integrated with Cucumber, TestNG, and Extent Reports libraries for managing, running tests, and generating reports. Maven is used as a Java project compiler to download the dependencies of these libraries.

## Check the Working test demo here: https://youtu.be/lAu4o084O40

## Prerequisites

The following tools and libraries are required to run this project locally on a macOS computer using a virtual Android device:

- Please note that you need to have Node.js and npm (Node Package Manager) installed on your system to run these commands. If you haven’t installed them yet, you can do so by following the instructions provided in the official Node.js website.
- **openjdk version 22**: You can download it here https://jdk.java.net/22/
- **Maven**: Install it using Homebrew with the command `brew install maven`.
- **Android Studio**: Download it from https://developer.android.com/studio and install it by following the instructions on the website. You will also need to set up a virtual Android device in the AVD Manager. Create one from Sndroid Studio itself.
- **Appium**: Install it using npm with the command `npm install -g appium`. Make sure you have Node.js and npm installed before running this command.
- **Install UiAutomator2 Driver**: Install the UiAutomator2 driver by running the following command in the terminal:`appium driver install uiautomator2` and check correct install by running `appium driver list`
- **IntelliJ IDEA**: Download it from https://www.jetbrains.com/idea/download/?section=mac and install it by following the instructions on the website.

## Cloning the Repository

To clone this repository, run the following command in your terminal: 
`git clone https://github.com/lucianoarguello335/appium.git`

## Libraries

The project uses the following libraries:

- selenium-java 4.20
- appium java-client 9.2.2
- testng 7.5.1
- cucumber-java 7.0.0
- cucumber-testng 7.0.0
- extent report 5.0.7

You can download these libraries using Maven by adding their dependencies to your `pom.xml` file. Like this:

## Install the James Rider APK
To install an Android app using an APK file on an Android Virtual Device (AVD), you can use the Android Debug Bridge (ADB) tool. Here are the steps to do this:

## Prerequisites
- Android Studio: Ensure you have Android Studio installed with the Android SDK and the necessary virtual device configurations.
- ADB: ADB comes bundled with the Android SDK, so you don't need to install it separately.

## Steps
1. Start Your Android Virtual Device (AVD):

- Open Android Studio.
- Go to the AVD Manager by clicking on the AVD icon in the toolbar or navigating through Tools > AVD Manager.
- Start your preferred virtual device.

2. Locate Your APK File:

- Make sure you have the APK file ready and note its location on your computer.

3. Open a Terminal
  
4. Navigate to the Directory Containing the APK File: `cd path/to/your/apk/file`

5. Install the APK Using ADB: `adb install james_rider.apk` (Replace james_rider.apk with the actual name of your APK file.)

## Running the Tests

Before running the tests, make sure the Appium server is running. You can start it by running the command `appium` in your terminal.

## To run the tests:
1. Open Android Studio and launch the Virtual Device. Wait until it starts and shows the main screen.
2. Run `appium` command on mac terminal. Wait for it to finish.
3. Run `adb devices` command on terminal and make sure it shows the virtual device you created on Android Studio as connected.
4. Run `mvn clean install` command on terminal and wait for it finish downloading dependencies.
5. Open Intellij or Eclipse
6. Right click on TestNGRunner.java and select "Run"


## Reports

After running the tests, an HTML report will be generated and saved in the `target/cucumber-reports` directory. You can view the report by opening the `cucumber-pretty.html` file in a web browser. Should look like this
![Screenshot 2024-05-19 at 18 18 34](https://github.com/lucianoarguello335/appium/assets/17627680/4d867b84-3fa7-4bee-bb9f-bf0b3dce6ca3)
