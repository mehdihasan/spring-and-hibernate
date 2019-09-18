# Clear Tomcat Cache

This is normally a caching issue with the cache.

Here are some steps to clear the Eclipse cache and Tomcat cache.

1. In the Server's tab in Eclipse, Stop the Tomcat server
2. Right-click the server and select "Clean..."
3. Right-click the server again and select "Clean Tomcat Work Directory..."
4. In the Eclipse, select the top-level menu option, Project > Clean
5. Be sure your project is selected and click Ok
6. Restart Eclipse


# Port already is in use issue

Steps to free port which is already used to run Tomcat server in Eclipse. For example , suppose 8080 port is used , we need to make free 8080 to run tomcat


### Mac/Linux SOLUTION

Step 0: Exit Eclipse

Step 1: Open a terminal window



Step 2: Enter the following command to find the process id
```
lsof -i :8080
```
This will give output of the application that is running on port 8080


Step 3: Enter the following command to kill the process
```
kill $(lsof -t -i :8080) 
```


Step 4:  Return back to Eclipse and start the Tomcat Server, it should start up now.


### Windows

Step 1: (open the CMD command)
```
C:\Users\username>netstat -o -n -a | findstr 0.0:8080
```
TCP    0.0.0.0:3000      0.0.0.0:0              LISTENING       3116

Now , we can see that LISTENING port is 3116 for 8080 ,

We need to kill 3116 now


Step 2:
```
C:\Users\username>taskkill /F /PID 3116
```


Step 3:  Return back to Eclipse and start the Tomcat Server, it should start up now.