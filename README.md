# Description
This project is used as a basis to show how the code interacts with web servers through Java, SQL, and jsp files.
This also sets a relation between the contractor, client, the negotiation quote, and more.  Part 2 is now about implementing the jsp files to interact with the users.  This part of the project is about the users and the client interacting with the requests for cutting trees and negotiating the price.  Part 3 is about the contractor and the user interacting through multiple tree orders and can distinguish between different clients from, the highest trees cut, overdue bills, etc...
# Table of contents
* [Prerequisite](#Prerequisite)
* [Instructions](#Instruction-Setup)
* [Run the code](#Run-the-code)
* [Contributions](#contributions)
* [Part 2 instructions](#Part-2-Project-Instructions)
* [Part 2 contributions](#Part-2-contributions)
* [Part 3 instructions](#Part-3-Project-Instructions)
  
# Prerequisite
1) Install Eclipse Enterprise and Java Developers
2) Follow the instructions when installing  [Apache Tomcat website ](https://tomcat.apache.org/)
3) Set up the Environmental Variables for JAVA_HOME: Java installation
4) Set up Envionmental Variables for CATALINA_HOME: set it to Tomcast directory

## Instruction Setup
1) Set the project and the Database project into your Eclipse workspace
2) Make sure that all of the nessesary files are in the workspace
3) Make sure the Tomcast server and all the packages/files are configured
4) Use the eclipse workspace to run the jsp files
5) Expand the WebContent folder from the Database folder, and you will see a buch of jsp files

# Run the code
1) Make sure that the tomcast server is working and syncronized
2) Hover any jsp file from the webcontent, and richt click
3) After right click, hover to "Run As> Run on Server"

#### Contributions
Will: 
* Worked on the ER diagram
* Worked on adding tuples
* Worked on setting up github.
  
Rishitha:
* Worked on ER diagram
* Worked on setting up the code
* Worked on jsp files

Combined working hours - 5 hours

Independent working hours:
* Rishitha - 20 
* Will - 20
###

### Part 2 Project Instructions:
Make sure that you did the nessesary steps to download and compile the project from part 1.

1) User goes to the login page form the login page
2) To register a user, they click the register action and input the nessasary information
3) Now that the new user is registered, now you need to log in
4) Now that the user is logged in, the user can make a request by inputting information about what tree to cut down wait for the contractor to respond to the request
5) Contractor has to log in and view the request
6) Contractor click 'send' from the tree request and makes the price for the tree cutting
7) The user and contractor can interact with the page by checking to see if there are any requests that have been accepted or need to be negotiated

## Part 2 contributions
Will: 
* Made the tables
* worked on the front end
* 20 hours

Rishitha: 
* Functionality of the code
* jsp interactions
* 25 hours

10 hours combined work 
### Part 3 Project Instructions:
Make sure that you follow the instructions on how to download the code and run it
For the user DAO functions, any code that has a password associated with the root, change the password to your own root password
1) User goes to the login page and registers as a client.
2) Once the information is completed, they then log into the account that was created
3) Users can then make a request with multiple tree orders
4) Once the contractor logs into his account, he can see the pending request and have the option to accept the request or reject it
5) Once the request has been accepted, the contractor can then generate the bill
6) User client needs to log into the pending bill and can negotiate the price
7) If the user does not like the bill, then the client can either renegotiate or reject the contract all together
8) Once the contracts have been accepted, you should see the queries change in the root login.

## Part 3 contributions:
Will: 
* Worked on each of the queries for the tables
* Worked on debugging any issues
* Worked on referencing the right tables to fit each query
* 45 hours

Rishitha: 
* front end
* back end
* Made more tables to fit the requirements
* 50 hours
  
