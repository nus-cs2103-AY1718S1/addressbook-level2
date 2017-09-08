package seedu.addressbook.data.person;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class personToAdd {
	private String name = "empty";                          //inputCounter 0 = name
	private String phone = "empty";                         //inputCounter 1 = phone & phone privacy
	private Boolean phonePrivacy = false;
	private String email = "empty";                         //inputCounter 2 = email & email privacy
	private Boolean emailPrivacy = false;
	private String address = "empty";                       //inputCounter 3 = address & address privacy
	private Boolean addressPrivacy = false;
	private HashSet<String> tags = new HashSet<String>();   //inputCounter 4 = Set of tags
	private Scanner sc = new Scanner(System.in);

	private Pattern pattern = Pattern.compile("(?<someString>[^/]+)(?<isPrivate>[/p]*)");

/*	This constructor is extra long because it handles user input
    to initialize the attributes of this object
    Users can type 'undo' anytime to undo their last entry
    */
	public personToAdd() {
		int inputCounter = 0;
		Boolean continueFlag;
		String input;
        System.out.println("NOTE: Enter 'undo' at any time to undo the last entry");
		while (inputCounter < 5) {
			continueFlag = false;
			switch (inputCounter) {
				case 0:
					System.out.print("Enter Name: ");
					break;
				case 1:
					System.out.print("Enter Phone Number (append /p to set as private): ");
					break;
				case 2:
					System.out.print("Enter Email (append /p to set as private): ");
					break;
				case 3:
					System.out.print("Enter Address (append /p to set as private): ");
					break;
				case 4:
					System.out.print("Enter tags (separated by commas): ");
					break;
			}

			input = sc.nextLine();

			if (input.equals("undo")){
				switch (inputCounter) {
					case 0:
						break;
					case 1:
						continueFlag = true;
						name = "empty";
						break;
					case 2:
						continueFlag = true;
						phone = "empty";
						phonePrivacy = false;
						break;
					case 3:
						continueFlag = true;
						email = "empty";
						emailPrivacy = false;
						break;
					case 4:
						continueFlag = true;
						address = "empty";
						addressPrivacy = false;
						break;
				}
				inputCounter--;
			}

			if (continueFlag) continue;

			switch (inputCounter) {
				case 0:
					this.name = input;
					break;
				case 1:
					Matcher pMatch = pattern.matcher(input);
					if (!pMatch.matches()) {
					} else {
						this.phone = pMatch.group("someString");
						this.phonePrivacy = "/p".equals(pMatch.group("isPrivate"));
					}
					break;
				case 2:
					Matcher eMatch = pattern.matcher(input);
					if (!eMatch.matches()) {
					} else {
						this.email = eMatch.group("someString");
						this.emailPrivacy = "/p".equals(eMatch.group("isPrivate"));
					}
					break;
				case 3:
					Matcher aMatch = pattern.matcher(input);
					if (!aMatch.matches()) {
					} else {
						this.address = aMatch.group("someString");
						this.addressPrivacy = "/p".equals(aMatch.group("isPrivate"));
					}
					break;
				case 4:
					for (String onetag: input.split(",")) {
						tags.add(onetag.trim());
					}
					break;
			}
			inputCounter++;
		}
	}

    public String getName() {
        return name;
    }

    public Boolean getPhonePrivacy() {
        return phonePrivacy;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getEmailPrivacy() {
        return emailPrivacy;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getAddressPrivacy() {
        return addressPrivacy;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public String getPhone() {
        return phone;
    }
}
