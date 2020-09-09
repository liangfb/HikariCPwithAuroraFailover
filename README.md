The Sample code for the Spring Boot Framework and HikariCP connection pool failover best practices when using aws Aurora MySQL RDS.

Key components:
- MariaDB JDBC Driver
- Connection String Parameters, e.g.: failover type, socketTimeout
- HikariCP Parameters.

The database connection from HikariCP will recover automatically when aws Aurora MySQL RDS failover completed.
