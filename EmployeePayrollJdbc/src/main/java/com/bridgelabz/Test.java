package com.bridgelabz;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class Test 
{
    public static void main( String[] args )
    {Config config = Config.getInstance();

    Connection connection = config.getConnection();

    if(connection != null)
        System.out.println(" Connection established");
    else
        System.out.println(" Connection failed");

    PreparedStatementDB statement = new PreparedStatementDB(connection);
  
    statement.update();
    statement.checkUpdate();
    }
}
