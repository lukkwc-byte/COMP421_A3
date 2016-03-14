public void Greeting() {
	System.out.println();
	System.out.println("****************************************************************");
	System.out.println();
	System.out.println("");
	System.out.println("");
	System.out.println("This system will allow you to access and modify the health records of the hospital");
	System.out.println();
	System.out.println("****************************************************************");
	System.out.println();
	Scanner scan = new Scanner(System.in);
	boolean exit = false;

public void Menu () {
	while (!exit) {

			System.out
					.println("Please select one of the following options and click enter:");
			System.out.println("   (1) Add a new patient to the EMR system\n"
					+ "   (2) Add a new Doctor to the EMR system\n"
					+ "   (3) Record new patient visit to the department\n"
					+ "   (4) Edit patient information\n"
					+ "   (5) Display list of all Patient IDs\n"
					+ "   (6) Display list of all Doctor IDs\n"
					+ "   (7) Print a Patient's record\n"
					+ "   (8) Print a Doctor's record\n"
					+ "   (9) Exit and save modifications\n");
			System.out.print("   ENTER YOUR SELECTION HERE: ");}
