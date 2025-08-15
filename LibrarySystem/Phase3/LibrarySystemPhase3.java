package LibrarySystem.Phase3;
import java.util.ArrayList;
import java.util.Scanner;
public class LibrarySystemPhase3 {
	public static void main(String[] args) {		
		//This code is to add books to the library and sort them
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
		 //bubble sort--------------------------------------------------
			SortBooks(libraryBooks);
		 //-------------------------------------------------------
		 System.out.println("The books in the library after sorting are: ");
		   for(Book counter: libraryBooks){
				System.out.println(counter.getTitle());
			}
		  
		 //This code is to add members to the library and sort them
			ArrayList<Member> libraryMembers = new ArrayList<Member>();
			String newMemberName;
			System.out.println("Create the members list by entering the member names one by one");		
			System.out.println("Enter a member name to be added to the library system");
			input = new Scanner(System.in);		
			newMemberName = input.next();		
			while (!(newMemberName.equals("end"))) {		
				libraryMembers.add(new Member(newMemberName));
				System.out.print("Enter a memer name to be added to the library");
				newMemberName = input.next();			
				}
			System.out.println("The members in the library before sorting are: ");
			   for(Member counter: libraryMembers){
					System.out.println(counter.getName());
				}
			 //bubble sort--------------------------------------------------
			   SortMembers(libraryMembers);
			 //-------------------------------------------------------
			 System.out.println("The members in the library after sorting are: ");
			   for(Member counter: libraryMembers){
					System.out.println(counter.getName());
				}		   
			  			   
			 //This code is to search for a specific book
		     System.out.println("Enter a book title to search for:");
			   bookToSearch = input.next();	
			   isBookFound = false;	
			   
		   //Linear Search----------------------------------------------
		   isBookFound = BookSearch(libraryBooks, bookToSearch);
		   //------------------------------------------------------------
		   if (isBookFound == true)
		       System.out.println("The book is found");
		   else if (isBookFound == false)
				   System.out.println("The book is not found");
		   //--------------------------------------------------------------
		   
		 //This code is to search for a specific member
		     System.out.println("Enter a member name to search for:");
			   memberToSearch = input.next();	
			   isMemberFound = false;	
			   
		   //Linear Search----------------------------------------------
		   isMemberFound = MemberSearch(libraryMembers, memberToSearch);
		   //------------------------------------------------------------
		   if (isMemberFound == true)
		       System.out.println("The member is found");
		   else if (isMemberFound == false)
				   System.out.println("The member is not found");
		   //--------------------------------------------------------------
	}

	public static void SortBooks(ArrayList<Book> list) {
		boolean sorted = false;
		Book temp = null;
		while(!sorted) {
			sorted = true;
			for (int i = 0; i < list.size() - 1; i++) {		           
				if((list.get(i).getTitle()).compareToIgnoreCase(list.get(i+1).getTitle())>0) {
					temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
					sorted = false;
				}
			}
		}
	}

	public static void SortMembers(ArrayList<Member> list) {
		boolean sorted = false;
		Member temp = null;
		while(!sorted) {
			sorted = true;
			for (int i = 0; i < list.size() - 1; i++) {		           
				if((list.get(i).getName()).compareToIgnoreCase(list.get(i+1).getName())>0) {
					temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
					sorted = false;
				}
			}
		}
	}

	public static Boolean BookSearch(ArrayList<Book> list, String elementToSearch){
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getTitle().equals(elementToSearch)) {
				return true;
			}
		}
		return false;
	}

	public static Boolean MemberSearch(ArrayList<Member> list, String elementToSearch){
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getName().equals(elementToSearch)) {
				return true;
			}
		}
		return false;
	}
}

class Book {
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
}

class Member {
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
}