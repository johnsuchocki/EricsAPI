package localhost.CRUDingEricsAPI;

import java.io.*;
import java.net.*;

public class CRUD {
	/**
	 * Class that completes the CRUD functions for the DB via the API
	 * 
	 * @author John Suchocki
	 * @date 9/7/16
	 * 
	 */

	// API url & char set - note no key is needed for this app
	protected static String endpoint = "http://localhost:1337/employee";
	protected static String charset = "UTF-8";

	public static void createNew() {

		try {
			/**
			 * The following are the parameters needed by the API in order to
			 * add new entries
			 */

			String firstName = "Dan";
			String lastName = "Dan";
			String email = "Dan@gmail.com"; // must be in standard email format
											// including @

			// Phone numbers must be in ###-###-####, ### ### ####, or
			// ###.###.#### formats
			String homePhone = "1234567890";
			String cellPhone = "0987654321";

			/**
			 * Must contain 1 upper case letter, 1 lower case letter, 1 symbol,
			 * and minimum of 8 total characters
			 */
			String password = "P4ssword";

			String active = "1"; // leave this as is unless other
									// functionalities of the API are revealed

			// builds query as a string to attach to endpoint URL
			String queryString = String.format(
					"firstName=%s&lastName=%s&email=%s&homePhone=%s&cellPhone=%s&password=%s&active=%s",
					URLEncoder.encode(firstName, charset), URLEncoder.encode(lastName, charset),
					URLEncoder.encode(email, charset), URLEncoder.encode(homePhone, charset),
					URLEncoder.encode(cellPhone, charset), URLEncoder.encode(password, charset),
					URLEncoder.encode(active, charset));

			// creates full URL, establishes connection, posts data. MAGIC!
			URL ericAPI = new URL(endpoint + "?" + queryString);
			HttpURLConnection connection = (HttpURLConnection) ericAPI.openConnection();
			connection.setRequestMethod("POST");

			// throws an error for unsuccessful additions
			if (connection.getResponseCode() != 201) {
				throw new RuntimeException("Failed: HTTP error code: " + connection.getResponseCode() + ". GLHF!");
			}

			System.out.println("Successfully added data.");

			connection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} // try catch block

	}// create new method

	public static void readOne() {

		try {

			String id = "3";// id # for data requested

			// creates full URL, establishes connection, gets data. MAGIC!
			URL ericAPI = new URL(endpoint + "/" + id);
			HttpURLConnection connection = (HttpURLConnection) ericAPI.openConnection();
			connection.setRequestMethod("GET");

			// throws an error for unsuccessful requests
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + connection.getResponseCode() + ". GLHF!");
			}

			BufferedReader readThis = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while (readThis.readLine() != null) {
				System.out.println(readThis.readLine());
			}

			connection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} // try catch block

	}// read one method

	public static void readAll() {

		try {

			// creates full URL, establishes connection, gets data. MAGIC!
			URL ericAPI = new URL(endpoint);
			HttpURLConnection connection = (HttpURLConnection) ericAPI.openConnection();
			connection.setRequestMethod("GET");

			// throws an error for unsuccessful requests
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + connection.getResponseCode() + ". GLHF!");
			}

			BufferedReader readThis = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while (readThis.readLine() != null) {
				System.out.println(readThis.readLine());
			}

			connection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} // try catch block

	}// real all method

	public static void delete() {

		try {

			String id = "6";// id # for the entry to be deleted

			// creates full URL, establishes connection, deletes data. MAGIC!
			URL ericAPI = new URL(endpoint + "/" + id);
			HttpURLConnection connection = (HttpURLConnection) ericAPI.openConnection();
			connection.setRequestMethod("DELETE");

			// throws an error for unsuccessful deletes
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + connection.getResponseCode() + ". GLHF!");
			}

			BufferedReader readThis = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while (readThis.readLine() != null) {
				System.out.println(readThis.readLine());
			}

			System.out.println("Data successfully deleted");

			connection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} // try catch block

	}// delete method

	public static void update() {
		try {

			// The id number is necessary for any updates
			String id = "7";

			/**
			 * The following are the parameters that can be updated by the API
			 * 
			 */

			String firstName = "Dan";
			String lastName = "Dan";
			String email = "Dan@gmail.com"; // must be in standard email format
											// including @

			// Phone numbers must be in ###-###-####, ### ### ####, or
			// ###.###.#### formats
			String homePhone = "1234567890";
			String cellPhone = "0987654321";

			/**
			 * Must contain 1 upper case letter, 1 lower case letter, 1 symbol,
			 * and minimum of 8 total characters
			 */
			String password = "Pa55w0rd";

			String active = "1"; // leave this as is unless other
									// functionalities of the API are revealed

			// builds query as a string to attach to endpoint URL
			String queryString = String.format(
					"firstName=%s&lastName=%s&email=%s&homePhone=%s&cellPhone=%s&password=%s&active=%s",
					URLEncoder.encode(firstName, charset), URLEncoder.encode(lastName, charset),
					URLEncoder.encode(email, charset), URLEncoder.encode(homePhone, charset),
					URLEncoder.encode(cellPhone, charset), URLEncoder.encode(password, charset),
					URLEncoder.encode(active, charset));

			// creates full URL, establishes connection, updates data. MAGIC!
			URL ericAPI = new URL(endpoint + "/" + id + "?" + queryString);
			HttpURLConnection connection = (HttpURLConnection) ericAPI.openConnection();
			connection.setRequestMethod("PUT");

			// throws an error for unsuccessful updates
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + connection.getResponseCode() + ". GLHF!");
			}

			System.out.println("Successfully updated data.");

			connection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} // try catch block
		
	} // update method

}// class
