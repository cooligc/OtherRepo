<h1>ServerSocketExample</h1>
<ul>
	<li> This example will have Socket as well as ServerSocket POC. How both can be connected and data can be transfer easily.</li>
	<li> This is unidirectional application. I mean, Only Clint can send the data and Server can Read the message token from its end.
		We can make this application by writing some extra code</li>
</ul>
<b>File Details</b>
<ul>
	<li> com.skc.client.ClientApp.java : This file is having all client realated code.</li>
	<li> com.skc.server.ServerApp.java : This file is having all Server related code. </li>
	<li> com.skc.util.NetworkUtils.java : This file is having all the utility code like ServerHost,ServerPort. We can get this stuff from properties file.As of now It is HardCoded</li>
</ul>
<b>Ho to Run ?</b>
<ul>
	<li> Download the application </li>
	<li> Import this project as a Maven Project into IDE</li>
	<li> Let the code to be compile or You can using any <u>mvn clean compile</u> . </li>
	<li> Check in target\classes folder is having the .class file or not. If their then ok, else compile each individually in command line</li>
	<li> As we have to run a Server as well as a Clint . So, we need to run this application in 2 JVM. Hence,Open 2 command console</li> 
	<li> In One command console run client and in other run Server.<br>
			<i>path\to\maven\project\target\classes> java com.skc.server.ServerApp</i> :: to run Server. We've to run Server First <br>
			<i>path\to\maven\project\target\classes> java com.skc.client.ClientApp</i> :: to run Client.</li>
	<li> Write any thing in Clint Console and It should reflect in the Server Console </li>
</ul>

<h1> Happy Learning <h1>