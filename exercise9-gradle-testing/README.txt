Advanced Java Collections Activity Version 1.0 8/7/2018

PROGRAM 

=================================================================

This program is an activity which makes use of the following:

- Java

- Gradle (Build-Tool)

- JUnit FrameWork 

- Mockito Mocking FrameWork


=================================================================

HOW TO RUN THE PROGRAM 

=================================================================

1. Download Zip File of the repository and extract files.

2. You could also just clone the git repository if you have git installed in your computer. To do this, just copy the git repository web url. Execute the command git clone URL. 

3. Open the Terminal or Command Prompt in your PC. 

4. Through the appropriate commands (i.e. cd), go to the folder of exercise9-gradle-testing with build.gradle and app, model and service folder.
 
5. Once there, you could run or execute gradle clean fatJar. This will create a fatJar in the app/build/libs folder which you can run later. 

**** The fatJar is a custom task used to create a jar of the program, containing all the dependencies needed for the program to run. **** 

6. After a jar of the program has been made, you can run it through the following ways:

  - From the base folder of the program (where you currently are), you can simply execute java -jar app/build/libs/collections-project-1.0.jar
=================================================================

Testing The App

=================================================================

- To execute the test cases on the application, you need to execute gradle clean test or gradle test. * opt to clean before you test to make sure classes tested are updated *

- If the program executes properly, it means that all the test cases have passed.

- If you wish to see the test results, go to the module or folder with the test cases you wish to check. 

- You could do this from your current folder then execute 'cd MODULE/build/reports/tests/test' (i.e. cd service/build/reports/tests/test)

- Copy full path of the index.html or you could also simply open it with browser if you are in your file manager. If you copy the full path, open your browser and paste the full path you just copied. 

- Here, you will see the tests that were executed and passed.

- Test Results can also be checked on the MODULe/build/test-results/test/binary. The xml files there contains the results for each test case that was executed. 

=================================================================

All Rights Reserved 2018 - Adrian Paolo M. Molina


