------------------------------------------------------------------------
This is the project README file. 
------------------------------------------------------------------------

PROJECT TITLE: Multi-Client Arithmetic TCP Server in Java

PURPOSE OF PROJECT: The purpose of this project is to implement a multi-client TCP server in Java (version 20) that performs arithmetic operations based on client requests.


LESSONS LEARNED:

Throughout the project, we encountered various learning points:

1.Template Utilization: We leveraged provided templates for the server and client. The Server template required minimal alterations as it supported multiple clients, aligning with our project requirements. However, we made slight modifications to the Client template to enhance user interface while retaining the provided functions.

2.Client-Server Architecture: Through extensive modifications to the Client Handler, we gained a deeper understanding of client-server communication. Initially, we faced challenges integrating the calculator code into the Server.java program. However, after studying the original code, we realized that Server.java merely spawns threads, while the actual communication occurs within the Client Handler. Consequently, we successfully implemented the calculator code into the ClientHandler.java.

3.Separation of Concerns: A key takeaway was the importance of separating concerns in software development. We learned that Server.java's primary role is thread creation, while Client Handler.java facilitates client-server interactions. This clear distinction in responsibilities improved code organization and readability.

4.Testing and Debugging: Writing a separate calculator Java code for testing server functionalities was insightful. This approach allowed us to isolate and verify the operations required for server functionality. Additionally, encountering and troubleshooting complications with unexpected user input and server lifecycle management enhanced our debugging skills.


REMAINING ISSUES:

Despite successful implementation, some issues persist:

1.Client Hangs on Unexpected Input: Unexpected (not properly formatted) user input causes the Client to be stuck. The Client must quit (ctrl-C) and start a new Client.

2.Server Lifecycle Management: The server remains online even after all clients disconnect, requiring manual termination.


FILE STRUCTURE:

NOTE: The following file structure was used. At first there were issues	running the programs when running the programs from inside client_server. Later tried running from mainProject and that worked.

The project followed a specific file structure:

mainProject
|
--client_server
  |
  --.java files: Server, Client, ClientHandler


USER INSTRUCTIONS:

To run the programs:

1.Navigate to the mainProject directory in the command line.
2.Compile each .java file using relative paths, e.g., javac "client_server/Server.java".
3.Start the server in one window using java "client_server/Server.java".
4.Start clients in separate windows using java "client_server/Client.java".

CONCLUSIONS:
This project provided valuable insights into network programming, concurrency in Java, and client-server architecture. Despite facing challenges, the experience enhanced our understanding of Java sockets and communication protocols. Moving forward, addressing the remaining issues will further improve the robustness and usability of the application.
