# MyExperimentsKeyPoints

This repository for my tech observations and listing out my key notes
<h2>SSL KEY SOFTWARE</h2>
If you want to insatll any ssl in java key store i gat a good open source key store software.
<b>portecle-1.11</b>
<h2>TOMCAT HANGING ISSUE</h2>
If the tomcat was hanged in the stopping position while you are running tomcat as awindows service below command will help you
sc queryex
list all services in windows
sc queryex tomcat8
list tomcat details find the processid of tomcat
taskkill /PID 2340 /F

# open JDK Github URL
https://github.com/ojdkbuild/ojdkbuild

#Tomcat SSL browser trusted

# Generate Keystore:
C:\localhostCerts>keytool -genkey -alias server-alias -keyalg RSA -keypass welcome -storepass welcome -keystore localhost.jks

keytool -export -alias server-alias -storepass welcome -file server.cer -keystore localhost.jks 
you will get below message
Certificate stored in file <server.cer>


