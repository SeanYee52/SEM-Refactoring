package LibrarySystem.Phase6;
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

class SortingService {

	public <T extends Sortable> void quickSort(ArrayList<T> list, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(list, low, high);
			quickSort(list, low, partitionIndex - 1);
			quickSort(list, partitionIndex + 1, high);
		}
	}

	private <T extends Sortable> int partition(ArrayList<T> list, int low, int high) {
		T pivot = list.get(high);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (list.get(j).getSortKey().compareToIgnoreCase(pivot.getSortKey()) <= 0) {
				i++;
				T temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		
		T temp = list.get(i + 1);
		list.set(i + 1, list.get(high));
		list.set(high, temp);
		
		return i + 1;
	}
}

class SearchingService {

	public <T extends Sortable> Boolean binarySearch(ArrayList<T> list, String elementToSearch, int low, int high) {
		if (low > high) {
			return false;
		}
		
		int mid = (low + high) / 2;
		String midKey = list.get(mid).getSortKey();
		
		if (midKey.equals(elementToSearch)) {
			return true;
		} else if (midKey.compareToIgnoreCase(elementToSearch) > 0) {
			return binarySearch(list, elementToSearch, low, mid - 1);
		} else {
			return binarySearch(list, elementToSearch, mid + 1, high);
		}
	}
}

public class LibrarySystemPhase6 {

	public static void main(String[] args) {
		// This code is to add books to the library and sort them
        SortingService sortingService = new SortingService();
        SearchingService searchingService = new SearchingService();
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

		// Use instantiated methods from SortingService class to sort library books.
        sortingService.quickSort(libraryBooks, 0, libraryBooks.size() - 1);

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

		// Use instantiated methods from SortingService class to sort library members.
        sortingService.quickSort(libraryMembers, 0, libraryMembers.size() - 1);

		System.out.println("The members in the library after sorting are: ");

		for (Member counter : libraryMembers) {
			System.out.println(counter.getName());
		}

		// This code is to search for a specific book
		System.out.println("Enter a book title to search for:");
		bookToSearch = input.next();
		isBookFound = false;

		// Use instantiated methods from SearchingService class to search a library book.
		isBookFound = searchingService.binarySearch(libraryBooks, bookToSearch, 0, libraryBooks.size() - 1);

		if (isBookFound == true)
			System.out.println("The book is found");
		else if (isBookFound == false)
			System.out.println("The book is not found");
		// --------------------------------------------------------------

		// This code is to search for a specific member
		System.out.println("Enter a member name to search for:");
		memberToSearch = input.next();
		isMemberFound = false;

		// Use instantiated methods from SearchingService class to search a library member.
		isMemberFound = searchingService.binarySearch(libraryMembers, memberToSearch, 0, libraryMembers.size() - 1);

		if (isMemberFound == true)
			System.out.println("The member is found");
		else if (isMemberFound == false)
			System.out.println("The member is not found");
		// --------------------------------------------------------------
	}
}