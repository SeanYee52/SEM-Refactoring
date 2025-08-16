package LibrarySystem.Phase1;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystemPhase1 {
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
		Boolean isBooksSorted = false;
		String tempBook = null;

		while (!isBooksSorted) {
			isBooksSorted = true;
			for (int i = 0; i < libraryBooks.size() - 1; i++) {
				if ((libraryBooks.get(i)).compareToIgnoreCase(libraryBooks.get(i + 1)) > 0) {
					tempBook = libraryBooks.get(i);
					libraryBooks.set(i, libraryBooks.get(i + 1));
					libraryBooks.set(i + 1, tempBook);
					isBooksSorted = false;
				}
			}
		}
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
		Boolean isMembersSorted = false;
		String tempMember = null;

		while (!isMembersSorted) {
			isMembersSorted = true;
			for (int i = 0; i < libraryMembers.size() - 1; i++) {
				if ((libraryMembers.get(i)).compareToIgnoreCase(libraryMembers.get(i + 1)) > 0) {
					tempMember = libraryMembers.get(i);
					libraryMembers.set(i, libraryMembers.get(i + 1));
					libraryMembers.set(i + 1, tempMember);
					isMembersSorted = false;
				}
			}
		}
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
		for (int index = 0; index < libraryBooks.size(); index++) {
			if (libraryBooks.get(index).equals(bookToSearch))
				isBookFound = true;
		}
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
		for (int index = 0; index < libraryMembers.size(); index++) {
			if (libraryMembers.get(index).equals(memberToSearch))
				isMemberFound = true;
		}
		// ------------------------------------------------------------
		if (isMemberFound == true)
			System.out.println("The member is found");
		else if (isMemberFound == false)
			System.out.println("The member is not found");
		// --------------------------------------------------------------
	}
}