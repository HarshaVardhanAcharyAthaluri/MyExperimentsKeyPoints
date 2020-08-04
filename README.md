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

# Open JDK Github URL
https://github.com/ojdkbuild/ojdkbuild

# Tomcat SSL browser trusted

# Generate Keystore:
C:\localhostCerts>keytool -genkey -alias server-alias -keyalg RSA -keypass welcome -storepass welcome -keystore localhost.jks

keytool -export -alias server-alias -storepass welcome -file server.cer -keystore localhost.jks 
you will get below message
Certificate stored in file <server.cer>
refer:
http://javakafunda.blogspot.com/2012/04/how-to-configure-tomcat-to-support-ssl.html
for javakeytool anf ssl
#https://sites.google.com/site/ddmwsst/create-your-own-certificate-and-ca


Making windows target machine accesble.
winrm set winrm/config/client/auth '@{Basic="true"}'
winrm set winrm/config/service/auth '@{Basic="true"}'

# Generating Certificate and key from existing keystore
certifictae </br>
openssl pkcs12 -in keystore.p12  -nokeys -out server.crt </br>
key </br>
openssl pkcs12 -in keystore.p12  -nodes -nocerts -out server.key
 
# Generating keystore from existing crt and key
openssl pkcs12 -export -in server.crt -inkey server.key -out keystore.p12

# When oracle sql* plus not showing properly
set lines 256 </br>
set trimout on </br>
set tab off

# Certificate generation with openssl
The following commands are needed to create a root certificate:</br>
openssl genrsa -des3 -out rootCA.key 2048</br>
openssl req -x509 -new -nodes -key rootCA.key -sha256 -days 1024  -out rootCA.pem</br>
The following commands are needed to create an SSL certificate issued by the self created root certificate:</br>
openssl req -new -nodes -out server.csr -newkey rsa:2048 -keyout server.key</br>
openssl x509 -req -in server.csr -CA rootCA.pem -CAkey rootCA.key -CAcreateserial -out server.crt -days 500 -sha256 -extfile v3.ext</br>
The referenced v3.ext file should look something like this:</br>
authorityKeyIdentifier=keyid,issuer</br>
basicConstraints=CA:FALSE</br>
keyUsage = digitalSignature, nonRepudiation, keyEncipherment, dataEncipherment</br>
subjectAltName = @alt_names</br>
[alt_names]</br>
DNS.1 = acme-site.dev</br>
DNS.2 = acme-static.dev</br>
In order to bundle the server certificate and private key into a single file the following command needs to be executed:</br>
openssl pkcs12 -inkey server.key -in server.crt -export -out server.pfx</br>

# Liked color Schema
`rgb(0, 133, 161)
`
# Dummy json api
https://jsonplaceholder.typicode.com/users



# Gain a token from postman by importing below curl

`
curl "https://localhost:8443/uaa/oauth/token" -i -X POST     -H "Content-Type: application/x-www-form-urlencoded"     -H "Accept: application/json"     -d "client_id=admin&client_secret=adminsecret&scope=scim.write&grant_type=client_credentials&token_format=opaque"
`
# Oauth token from postman

Key          | value
------------ | -------------
url          |https://localhost:8443/uaa/oauth/token 
Method       |Post
headers      |Content-Type:application/x-www-form-urlencoded<br/>Accept:application/json
Request Body |client_id:admin<br/>client_secret:adminsecret<br/>grant_type:client_credentials

# OKTA + PCF
https://docs.pivotal.io/p-identity/1-10/okta/config-okta.html

# CF ERROR -> Response issue time is either too old or with date in the future, skew 60

Just add the property responseSkew to the WebSSOProfileConsumerImpl and SingleLogoutProfileImpl beans:

<bean id="webSSOprofileConsumer" class="org.springframework.security.saml.websso.WebSSOProfileConsumerImpl">
    <property name="responseSkew" value="600"/> <!-- 10 minutes -->
</bean>

<bean id="logoutprofile" class="org.springframework.security.saml.websso.SingleLogoutProfileImpl">
    <property name="responseSkew" value="600"/> <!-- 10 minutes -->
</bean>
