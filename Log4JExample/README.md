<b>Log4J</b>

<p>To Log the message in any application we need a tool, Basically for Java based application we may used Log4j or SLF4J. 
Here is the POC for Log4J.</p>

<b>Prerequisite:-</b>
<ul><li>Core Java basic knowledge</li>
<li>Maven basic Knowledge as the application uses maven.</li></ul>

<b>Configuration for Log4j:-</b>
<p>If you are using Log4j tool for a stand alone application then, we may configure the same in 2 ways. Such as,</p>
 <ul><li>Using XML file</li> 
 <li>Using Properties file.</li></ul>
 <p>If you are using the same tool in any web based application then, You may configure the Log4j configuration file location using a Listener in web.xml
 In this application, I am logging the message for a Stand - Alone Application.	</p>
 
<b>Log4J configuration using XML:-</b>
<p>To configure the Log4J using XML , we need to write an XML file named as log4j.xml(mandatory).
In this xml, we need to configure an Appender
Inside the Appender, we need to configure the Log4j Max Fil Size , Logging pattern..etc.</p>

<p>The log4j.xml file is present in the src/main/resource folder. Please do have a look.</p>

<b>Log4J configuration using Properties file:-</b>
<p>We need to write a properties file named as log4j.properties and need to configure Appender, pattern , and extra meta data info.
I have change the properties file name as log4j_properties.properties , It because , I have configure the XML based Log4j also.
So, when ever you need to configure Properties file based Log4J , then delete the log4j.xml and change the name of properties file from log4j_properties.properties to log4j.properties.</p>

 
