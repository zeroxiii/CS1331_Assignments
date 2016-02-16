/* Name: Rahmaan Lodhia
 * Prism: rlodhia3 
 * Collaboration: "I worked on the homework assignment alone, using only course materials."
 */

/**
 * Name
 * This class creates an object that contains the name of a person.
 * The class contains method to modify and access these elements.
 */
public class Name 
{
	//Variables to be used throughout the object
	private String firstName, middleName, lastName;
	public enum NameFormat {firstMiddleLast, lastFirstMiddle, firstInitialLast, initialInitialLast} 
	
	/**
	 * Name Constructor
	 * 
	 * @param first  String containing first name
	 * @param middle String containing middle name
	 * @param last   String containing last name
	 */
	public Name(String first, String middle, String last)
	{
		firstName = first;
		middleName = middle;
		lastName = last;
	}
	
	
	/**
	 * getFirstName()
	 * 
	 * @return firstName String
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	
	/**
	 * getMiddleName()
	 * 
	 * @return middleName String
	 */
	public String getMiddleName()
	{
		return middleName;
	}

	
	/**
	 * getLastName()
	 * 
	 * @return lastName String
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	
	/**
	 * getFullName()
	 * Return full name with specified format
	 * @param format  NameFormat variable
	 * @return fullName String
	 */
	public String getFullName(NameFormat format)
	{
		String name = "";
		switch(format)
		{
			case firstMiddleLast:
			{
				name = firstName + " " + middleName + " " + lastName;
				break;
			}
			
			case lastFirstMiddle:
			{
				name = lastName + ", " + firstName + " " + middleName; 
				break;
			}
			
			case firstInitialLast:
			{
				name = firstName + " " + middleName.substring(0,1) + ". " + lastName;
				break;
			}
			
			case initialInitialLast:
			{
				name = firstName.substring(0,1) + ". " + middleName.substring(0, 1) + ". " + lastName;
				break;
			}
			
			default:
				break;
		}
		
		return name;
	}
	
	
	/**
	 * normalize()
	 * Formats each name to have the proper capitalization.
	 */
	public void normalize()
	{
		firstName = (firstName.substring(0,1)).toUpperCase() + (firstName.substring(1)).toLowerCase();
		middleName = (middleName.substring(0,1)).toUpperCase() + (middleName.substring(1)).toLowerCase();
		lastName = (lastName.substring(0,1)).toUpperCase() + (lastName.substring(1)).toLowerCase();
	}
	
	
	/**
	 * intials()
	 * Forms initials from name
	 * @return intials String
	 */
	public String initials()
	{
		return firstName.substring(0,1) + middleName.substring(0,1) + lastName.substring(0,1);
	}
	
	
	/**
	 * length()
	 * Counts the letters in the name minus the spaces
	 * @return length of name (int)
	 */
	public int length()
	{
		return firstName.length() + middleName.length() + lastName.length();
	}

	
}
