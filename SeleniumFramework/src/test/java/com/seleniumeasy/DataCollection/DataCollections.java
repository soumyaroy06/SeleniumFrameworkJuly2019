package com.seleniumeasy.DataCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataCollections {

	String excelPath = System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
	private static Fillo fillo;
	private static Connection connection;
	private static Recordset recordSet;
	public DataCollections() throws FilloException
	{
		fillo = new Fillo();
		connection = fillo.getConnection(excelPath);
	}
	@DataProvider(name = "dataCollection_SubmitForm")
	public static Iterator<String[]> dataCollectionSubmitForm()
	{
		List<String[]> lst = new ArrayList<String[]>();
		String query = "select scenario, firstname, lastname, email, state from sheet1 where flag='Y' and scenario ='SubmitForm'";
		try
		{
			recordSet = connection.executeQuery(query);
			if(recordSet!=null)
			{
				while(recordSet.next())
				{
					String[] str = new String[5];
					str[0]=recordSet.getField("scenario");
					str[1]=recordSet.getField("firstname");
					str[2]=recordSet.getField("lastname");
					str[3]=recordSet.getField("email");
					str[4]=recordSet.getField("state");
					lst.add(str);
				}
			}
		}
		catch(NullPointerException e)
		{
			e.toString();
		}
		catch(FilloException e)
		{
			e.toString();
		}
		catch(Exception e)
		{
			e.toString();
		}
		return lst.iterator();
	}
}
/*public class DataCollections 
{
	private Fillo fillo;
	private Connection con;
	private Recordset rs;
	private String excelPath = System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
	private String readQuery;

	public DataCollections() throws FilloException
	{
		fillo = new Fillo();
		con = fillo.getConnection(excelPath);
	}

	@DataProvider(name="DataCollection_SubmitForm")
	public Iterator<String[]> dataCollection_SubmitForm() throws FilloException
	{
		List<String[]> lst=new ArrayList<String[]>();
		readQuery = "select scenario, firstname, lastname, email, state from sheet1 where flag='Y' and scenario='SubmitForm'";
		try 
		{
			rs=con.executeQuery(readQuery);
			if(rs!=null)
			{
				while(rs.next()) 
				{
					String[] str = new String[5];
					str[0]=rs.getField("scenario");
					str[1]=rs.getField("firstname");
					str[2]=rs.getField("lastname");
					str[3]=rs.getField("email");
					str[4]=rs.getField("state");
					lst.add(str);
				}
			}
		}
		catch(NullPointerException e)
		{
			Reporter.log("............Record value is null............");
		}
		return lst.iterator();
	}


}
 */