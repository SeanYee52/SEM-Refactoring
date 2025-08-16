package LibrarySystem.Phase2;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystemPhase2 {

	public static void sortElements(ArrayList<String> list) {
		boolean sorted = false;
		String temp = null;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < list.size() - 1; i++) {
				if ((list.get(i)).compareToIgnoreCase(list.get(i + 1)) > 0) {
					temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
					sorted = false;
				}
			}
		}
	}

	public static Boolean linearSearch(ArrayList<String> list, String elementToSearch) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).equals(elementToSearch)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// This code is to add books to the library and sort them
		ArrayList<String> libraryBooks = new ArrayList<String>();
		String newBookTitle;
		String bookToSearch = null;
		String memberToSearch = null;
		Boolean isBookFound;
		Boolean isMemberFound;
		System.out.println("Create the book list by entering the book titles book by book");
		System.out.println("Enter a book title to be added to the library");
		Scanner input = new Scanner(System.in);
		newBookTitle = input.next();

		while (!(newBookTitle.equals("end"))) {
			libraryBooks.add(newBookTitle);
			System.out.print("Enter a book title to be added to the library");
			newBookTitle = input.next();
		}

		System.out.println("The books in the library before sorting are: ");

		for (String counter : libraryBooks) {
			System.out.println(counter);
		}

		// bubble sort --------------------------------------------------
		sortElements(libraryBooks);
		// -------------------------------------------------------

		System.out.println("The books in the library after sorting are: ");

		for (String counter : libraryBooks) {
			System.out.println(counter);
		}

		// This code is to add members to the library and sort them
		ArrayList<String> libraryMembers = new ArrayList<String>();
		String newMemberName;
		System.out.println("Create the members list by entering the member names one by one");
		System.out.println("Enter a member name to be added to the library system");
		newMemberName = input.next();

		while (!(newMemberName.equals("end"))) {
			libraryMembers.add(newMemberName);
			System.out.print("Enter a member name to be added to the library");
			newMemberName = input.next();
		}

		System.out.println("The members in the library before sorting are: ");

		for (String counter : libraryMembers) {
			System.out.println(counter);
		}

		// bubble sort --------------------------------------------------
		sortElements(libraryMembers);
		// -------------------------------------------------------

		System.out.println("The members in the library after sorting are: ");

		for (String counter : libraryMembers) {
			System.out.println(counter);
		}

		// This code is to search for a specific book
		System.out.println("Enter a book title to search for:");
		bookToSearch = input.next();
		isBookFound = false;

		// Linear Search ----------------------------------------------
		isBookFound = linearSearch(libraryBooks, bookToSearch);
		// ------------------------------------------------------------
		if (isBookFound == true)
			System.out.println("The book is found");
		else if (isBookFound == false)
			System.out.println("The book is not found");
		// --------------------------------------------------------------

		// This code is to search for a specific member
		System.out.println("Enter a member name to search for:");
		memberToSearch = input.next();
		isMemberFound = false;

		// Linear Search ----------------------------------------------
		isMemberFound = linearSearch(libraryMembers, memberToSearch);
		// ------------------------------------------------------------
		if (isMemberFound == true)
			System.out.println("The member is found");
		else if (isMemberFound == false)
			System.out.println("The member is not found");
		// --------------------------------------------------------------
	}

}