package LibrarySystem.Phase4;
import java.util.ArrayList;
import java.util.Scanner;

interface Sortable {
	String getSortKey();
}

class Book implements Sortable {
	private String title;

	public Book(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
    }

	@Override
	public String getSortKey() {
		return this.title;
	}
}

class Member implements Sortable {
	private String name;

	public Member(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getSortKey() {
		return this.name;
	}
}

public class LibrarySystemPhase4 {

	public static <T extends Sortable> void sortItems(ArrayList<T> list) {
		boolean isSorted = false;
		T temp = null;
		while(!isSorted) {
			isSorted = true;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).getSortKey().compareToIgnoreCase(list.get(i+1).getSortKey()) > 0) {
					temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
					isSorted = false;
				}
			}
		}
	}

	public static <T extends Sortable> Boolean searchItems(ArrayList<T> list, String elementToSearch) {
		for(T item : list) {
			if(item.getSortKey().equals(elementToSearch)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// This code is to add books to the library and sort them
		ArrayList<Book> libraryBooks = new ArrayList<Book>();
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
			libraryBooks.add(new Book(newBookTitle));
			System.out.print("Enter a book title to be added to the library");
			newBookTitle = input.next();
		}

		System.out.println("The books in the library before sorting are: ");
		for(Book counter: libraryBooks){
			System.out.println(counter.getTitle());
		}

		// Using parametrized sortItems method
		sortItems(libraryBooks);

		System.out.println("The books in the library after sorting are: ");

		for (Book counter : libraryBooks) {
			System.out.println(counter.getTitle());
		}

		// This code is to add members to the library and sort them
		ArrayList<Member> libraryMembers = new ArrayList<Member>();
		String newMemberName;
		System.out.println("Create the members list by entering the member names one by one");
		System.out.println("Enter a member name to be added to the library system");
		newMemberName = input.next();

		while (!(newMemberName.equals("end"))) {
			libraryMembers.add(new Member(newMemberName));
			System.out.print("Enter a member name to be added to the library");
			newMemberName = input.next();
		}

		System.out.println("The members in the library before sorting are: ");

		for (Member counter : libraryMembers) {
			System.out.println(counter.getName());
		}

		// Using parametrized sortItems method
		sortItems(libraryMembers);

		System.out.println("The members in the library after sorting are: ");

		for (Member counter : libraryMembers) {
			System.out.println(counter.getName());
		}

		// This code is to search for a specific book
		System.out.println("Enter a book title to search for:");
		bookToSearch = input.next();
		isBookFound = false;

		// Using parametrized searchItems method
		isBookFound = searchItems(libraryBooks, bookToSearch);

		if (isBookFound == true)
			System.out.println("The book is found");
		else if (isBookFound == false)
			System.out.println("The book is not found");
		// --------------------------------------------------------------

		// This code is to search for a specific member
		System.out.println("Enter a member name to search for:");
		memberToSearch = input.next();
		isMemberFound = false;

		// Using parametrized searchItems method
		isMemberFound = searchItems(libraryMembers, memberToSearch);

		if (isMemberFound == true)
			System.out.println("The member is found");
		else if (isMemberFound == false)
			System.out.println("The member is not found");
		// --------------------------------------------------------------
	}

}