package com.skc.api.google.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListThreadsResponse;

@Component("gmailService")
@Path("/gmail")
public class GmailAPIDemo {
	// Check https://developers.google.com/gmail/api/auth/scopes for all available scopes
	  private static final String SCOPE = "https://www.googleapis.com/auth/gmail.readonly";
	  private static final String APP_NAME = "Gmail API Quickstart";
	  // Email address of the user, or "me" can be used to represent the currently authorized user.
	  private static final String USER = "me";
	  // Path to the client_secret.json file downloaded from the Developer Console
	  private  String clientCertPath;//"client_secret.json";
	 

	  private static GoogleClientSecrets clientSecrets;

	  
	  @GET
	  public Response getResponse() throws IOException {
		  
		GmailAPIDemo apiDemo = new GmailAPIDemo();
		System.out.println(apiDemo.getClientCertPath());  
		
		
	    HttpTransport httpTransport = new NetHttpTransport();
	    JsonFactory jsonFactory = new JacksonFactory();

	    clientSecrets = GoogleClientSecrets.load(jsonFactory,  new FileReader(apiDemo.getClientCertPath()));

	    // Allow user to authorize via url.
	    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	        httpTransport, jsonFactory, clientSecrets, Arrays.asList(SCOPE))
	        .setAccessType("online")
	        .setApprovalPrompt("auto").build();

	    String url = flow.newAuthorizationUrl().setRedirectUri(GoogleOAuthConstants.OOB_REDIRECT_URI)
	        .build();
	    System.out.println("Please open the following URL in your browser then type"
	                       + " the authorization code:\n" + url);

	    // Read code entered by user.
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String code = br.readLine();

	    // Generate Credential using retrieved code.
	    GoogleTokenResponse response = flow.newTokenRequest(code)
	        .setRedirectUri(GoogleOAuthConstants.OOB_REDIRECT_URI).execute();
	    GoogleCredential credential = new GoogleCredential()
	        .setFromTokenResponse(response);

	    // Create a new authorized Gmail API client
	    Gmail service = new Gmail.Builder(httpTransport, jsonFactory, credential)
	        .setApplicationName(APP_NAME).build();

	    // Retrieve a page of Threads; max of 100 by default.
	    ListThreadsResponse threadsResponse = service.users().threads().list(USER).execute();
	    List<com.google.api.services.gmail.model.Thread> threads = threadsResponse.getThreads();

	    // Print ID of each Thread.
	    for (com.google.api.services.gmail.model.Thread thread : threads) {
	      System.out.println("Thread ID: " + thread.getId());
	    }
		return Response.status(Status.OK).build();
	  }

	/**
	 * @return the clientCertPath
	 */
	public String getClientCertPath() {
		return clientCertPath;
	}

	/**
	 * @param clientCertPath the clientCertPath to set
	 */
	public void setClientCertPath(String clientCertPath) {
		this.clientCertPath = this.getClass().getClassLoader().getResource("client_secret.json").getPath();;
	}
}
