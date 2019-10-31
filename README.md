download and install mariaDb from https://mariadb.org/download/

take note of the password for root to use when connecting to database from glassfish server.

download the maria db jar file here https://downloads.mariadb.com/Connectors/java/connector-java-2.4.4/mariadb-java-client-2.4.4.jar
 
save downloaded file to glassfish domains lib folder.(per mysql page)
C:\Users\natal\GlassFish_Server\glassfish\domains\domain1\lib



In NetBeans add driver to netbeans under services tab. right click drivers, add new driver, select the maria db jar file. Enter a driver name MariaDB.

in services tab in netbeans right click on databases and select new connection. select the MariaDB driver from the drop down and click next.

enter the password for root and click test connection.  

the JDBC URL should be: jdbc:mariadb://localhost:3306/mysql

click finish.

the new connection should be visible under databases.

right click the database and click connect.
expand the connection and expand mysql database
right click on tables and click excute command
run the database script to create the dukes bookstore database:
paste the code to create the dukes database into the SQL command page and click the Run SQL icon or press Ctrl+Shift+E


start the glassfish server from services tab in netbeans.
use chrome to navigate to glassfish server http://localhost:4848/common/index.jsf

In the GlassFish Administration Console, using the navigation tree navigate to Resources, JDBC, Connection Pools.

In the JDBC Connection Pools frame click New. You will enter a two step wizard.

In the Name field under General Settings enter the name for the connection pool, for example enter MariaDB.

In the Resource Type field, select javax.sql.DataSource from the drop-down listbox.

In the Database Vendor field, MariaDB in the textbox. Click Next to go to the next page of the wizard.


for DataSource or driver enter
DataSource Classname: org.mariadb.jdbc.MariaDbDataSource
Driver classname: org.mariadb.jdbc.Driver

Click next

enter the following properties

User		duke
port		3306
password	Password1234
database	dukes
url		jdbc:mariadb://localhost:3306/dukes
DriverClass	org.mariadb.jdbc.Driver

click finish

in Glassfish go to JDBC Resources and select new

Enter name for JNDI eg Maria
select the mariaDB connection pool created in the last steps
click ok

create a github account
in Netbeans from the menu select team | git | clone
repository url: https://github.com/u1069791Natalie/uni
enter github account details
click next
select master
click next
choose parent directory
clone name
branch master
remote name: origin
ensure Scan for NetBeans Projects is checked
click finish
click open project
navigate to dukes-bookstore
click open



