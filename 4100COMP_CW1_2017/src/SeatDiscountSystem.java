import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SeatDiscountSystem {

	public static void main(String[] args) throws FileNotFoundException {

		double discountRate = 20;
		String choice = null;

		final Scanner S = new Scanner(System.in);
		final Scanner FR = new Scanner(new FileReader("M:\\Data\\seats.txt"));

		//Loop to validate users input by only allowing Y or N
		while (choice != "Y" || choice != "N"){
		System.out.println("\t---Seat Discount System---\n");
		System.out.print("Do you want to enter your own discount rate? [Y/N]:  ");
		choice = S.next().toUpperCase();

		if(choice.equals("Y")  || choice.equals("N")){
		break;
		}
		else {
			System.out.print("---ERROR---");
			System.out.println("\nPlease enter Y or N");
		}

		}
		//Checks the users input and then decides if the default rate or a new rate should be used

		if (choice.equals("Y")){
			System.out.print("\nPlease enter new rate: ");
			discountRate = Double.valueOf(S.next());
			System.out.printf("\nYou are now using the discount rate of %.1f%% \n\n",discountRate);
		}
		else {
			System.out.println("\nDefault rate of " + discountRate + "% will be used \n");
		}

		double discount, income, totalIncome = 0, totalDiscount = 0;

		//Loops through the file as long as there is data that can be read
		//While looping the two total variables are being accumulated

		while (FR.hasNext()) {
			String seatType = FR.next();
			double seatPrice = Double.valueOf(FR.nextDouble());
		int bookings = Integer.valueOf(FR.nextInt());

		discount = ((seatPrice * bookings)/100) * discountRate;
		income = (seatPrice * bookings) - discount;
		totalDiscount = totalDiscount + discount;
		totalIncome = totalIncome + income;

		//Outputs the data for each seat
		System.out.printf("Seat Type : %s \t Seat Price : �%.2f \t Bookings : %d \t Discount : %.2f \t Income : �%.2f \n", seatType, seatPrice, bookings, discount, income);
		}

		//Takes the two total values from the loop and outputs their final value
		System.out.printf("\nTotal Income: �%.2f\n",totalIncome);
		System.out.printf("\nTotal Discount: �%.2f",totalDiscount);

		S.close();
		FR.close()
	}


}
