import java.io.*;
import java.lang.*;
import java.util.*;

public class AddressBookEntry 
{
	private String name;
	private String email;
	private String cellNumber;

	AddressBookEntry(String name, String email, String cellNumber) 
	{
		this.name = name;
		this.email = email;
		this.cellNumber = cellNumber;
	}

	public String getName()
	{
		return this.name;
	}

	public String getEmail() 
	{
		return this.email;
	}

	public String getCellNumber()
	{
		return this.cellNumber;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public void setCellNumber(String cellNumber)
	{
		this.cellNumber = cellNumber;
	}
}