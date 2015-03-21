<b>Log4J</b>
~~~~~
To Log the message in any application we need a tool, Basically for Java based application we may used Log4j or SLF4J. 
Here is the POC for Log4J.

<b>Prerequisite:-</b>
1.Core Java basic knowledge
2.Maven basic Knowledge as the application uses maven.

<b>Configuration for Log4j:-</b>
-If you are using Log4j tool for a stand alone application then, we may configure the same in 2 ways. Such as,
 Using XML file 
 Using Properties file.
 If you are using the same tool in any web based application then, You may configure the Log4j configuration file location using a Listener in web.xml
 In this application, I am logging the message for a Stand - Alone Application.	
 
<b>Log4J configuration using XML:-</b>
To configure the Log4J using XML , we need to write an XML file named as log4j.xml(mandatory).
In this xml, we need to configure an Appender
Inside the Appender, we need to configure the Log4j Max Fil Size , Logging pattern..etc.

The log4j.xml file is present in the src/main/resource folder. Please do have a look.

<b>Log4J configuration using Properties file:-</b>
We need to write a properties file named as log4j.properties and need to configure Appender, pattern , and extra meta data info.
I have change the properties file name as log4j_properties.properties , It because , I have configure the XML based Log4j also.
So, when ever you need to configure Properties file based Log4J , then delete the log4j.xml and change the name of properties file from log4j_properties.properties to log4j.properties.

 