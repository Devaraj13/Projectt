package package1;
import java.io.File; 
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;  

public class LockerProject {
	
	static final String projectFilesPath 	= "C:\\Users\\DEVARAJ\\eclipse-workspace\\LockerMe\\User1";
	static final String errorMessage 		= "Some error occurred. Please contact : admin@lockedme.com";
	
	public static void main(String[] args) 
	{
		Scanner obj = new Scanner(System.in);
		int ch;
		
		do
		{
			displayMenu();
			System.out.println("Enter your choice");
			ch = Integer.parseInt(obj.nextLine());
		
			switch(ch)
			{
				case 1:getAllFiles();
				break;
				case 2:createFiles();
				break;
				case 3:deleteFiles();
				break;
				case 4:searchFiles();
				break;
				case 5:System.exit(0);
				break;
			}
		}
		while(ch>0);
		obj.close();
}


public static void displayMenu()
{
	System.out.println("***********************************");
	System.out.println("\t\t Welcome to Lockedme.com");
	System.out.println("************************************");
	System.out.println("\t\t1. Dispaly all the files");
	System.out.println("\t\t2. Add a new file");
	System.out.println("\t\t3. Delete a new file");
	System.out.println("\t\t4. Search a new file");
	System.out.println("\t\t5. Exit");
	
}

public static void getAllFiles()
{
	try
	{
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length == 0)
		{
			System.out.println("No files exist in the directory");
		}
		else
		{	
			//Get all the fileNames
			for(var l: listOfFiles  )
			{
				System.out.println(l.getName());
			}
		}
	}
	catch(Exception ex)
	{
		System.out.println(errorMessage);
	}
}
public static void createFiles()
{
	try
	{
		String fileName ;
	
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		fileName = obj.nextLine();
	
		FileWriter fw = new FileWriter(projectFilesPath+"\\"+fileName);
		
		fw.write("Hi");
				
		System.out.println("File Created Successfully.");
				
	}
	catch(Exception ex)
	{
		System.out.println(errorMessage);
	}
}
public static void deleteFiles()
{
	Scanner obj = new Scanner(System.in);
	try
	{
		String fileName ;
		
		System.out.println("Enter the file name to be deleted: ");
		fileName = obj.nextLine();
		
		File file = new File(projectFilesPath+"\\"+fileName);
		
		if(file.exists())
		{
			file.delete();
			System.out.println("File deleted successfully:" +fileName);
		}
		else 
		{
			System.out.println("File does not exist");
		}
	}
	catch(Exception ex)
	{
		System.out.println(errorMessage);
	}
}

public static void searchFiles()
{
	Scanner obj = new Scanner(System.in);
	try
	{
		String fileName ;
		
		System.out.println("Enter the final name to be searched:");
		
		fileName = obj.nextLine();
		
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		LinkedList<String> fileNames = new LinkedList<String>();
		for(var l:listOfFiles)
			fileNames.add(l.getName());
		if(fileNames.contains(fileName))
		{
			System.out.println("File is available");
		}
		else
		{
			System.out.println("File is not available");
		}
	}
	catch(Exception ex)
	{
		System.out.println(errorMessage);
	}
}
}