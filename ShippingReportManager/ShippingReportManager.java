import java.util.Scanner;
import java.io.*;

public class ShippingReportManager {

public static void main(String[] args)throws IOException{

final String INPUT_FILE = "shippingData.txt";
final String OUTPUT_FILE = "shippingReport.txt";
final int inventoryCount = 7;

File fn = new File(INPUT_FILE);
Scanner dataIn = new Scanner(fn);

PrintWriter dataOut = new PrintWriter(OUTPUT_FILE);

Scanner keyboard = new Scanner(System.in);

	Shipping[] ship = new Shipping[inventoryCount];
	fillArray(dataIn,ship);

	int printSelection = getPrintSelection(keyboard);
	int menuSelection = displayMenu(keyboard);
	displayMenuSelection(dataOut,printSelection,keyboard,menuSelection,ship);

dataIn.close();
dataOut.close();
keyboard.close();
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void fillArray(Scanner dataFile, Shipping[] ship){
	int indx = 0;

	while(dataFile.hasNext()){
	ship[indx] = new Shipping();
	ship[indx].referenceNumber(dataFile.nextInt());
		if(dataFile.hasNext())dataFile.nextLine();
	ship[indx].address(dataFile.nextLine());
	ship[indx].weightClass(dataFile.nextInt());
	ship[indx].sizeClass(dataFile.nextInt());
	ship[indx].deliveryZone(dataFile.nextInt());
	indx++;}
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void displayData(PrintWriter rpt, int printSelection,Shipping ship){
	String fmtStr = "%-6d      %-15s     %-11s     %-11s      %5s       $%-5.2f\n";
	writeToFile(rpt,printSelection,String.format(fmtStr,ship.referenceNumber(),ship.address(),getWeightClass(ship),getSizeClass(ship),getDeliveryZone(ship),cost(ship)));}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void displayHeader(PrintWriter rpt, int printSelection){
	String strHdg = "      %-25s\n\n";
	String strHdg1 = "%-10s    %-10s          %-10s       %-10s  %-10s\n";
	String strHdg2 = " %-9s    %-10s          %-10s       %-10s    %-10s   %-10s\n";
	String strHdg3 = "%-10s    %-10s          %-10s       %-10s  %-10s     %-10s\n\n";
	writeToFile(rpt,printSelection,String.format(strHdg1,"Reference","Street","Weight", "Size","Delivery"));
	writeToFile(rpt,printSelection,String.format(strHdg2,"Number","Address","Class", "Class","Zone", "Cost"));
	writeToFile(rpt,printSelection,String.format(strHdg3,"=========","=======","======", "=====","========","===="));
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static int getPrintSelection(Scanner keyboard){
	int printSelection = 0;
			do{
				System.out.println("1) Display to Screen, 2) Send to File, 3) Both");
				printSelection = keyboard.nextInt();
				if(printSelection<1 || printSelection>3)
				System.out.println("invalid selection re-enter");
			} while(printSelection<1 || printSelection>3);

			return printSelection;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void writeToFile(PrintWriter rpt, int printSelection,String oStr){
		if(printSelection == 2 || printSelection == 3) rpt.print(oStr);
		if(printSelection == 1 || printSelection == 3) System.out.print(oStr);
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void writeReport(PrintWriter rpt, int printSelection,Shipping[] shipArray){
	displayHeader(rpt,printSelection);
	for(int indx = 0; indx < shipArray.length; indx++) displayData(rpt,printSelection,shipArray[indx]);
	displayTotal(rpt,printSelection,shipArray);
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void sortArrayByReference(Shipping[] ship){
	Shipping tempShip;
	for(int indx = 0; indx< ship.length - 1; indx++){
		for (int indx1 = indx + 1; indx1 < ship.length; indx1++){
			if(ship[indx].referenceNumber() > ship[indx1].referenceNumber()){
				tempShip = ship[indx];
				ship[indx] = ship[indx1];
				ship[indx1] = tempShip;}
		}
	}
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void sortArrayByName(Shipping[] ship){
	Shipping tempShip;
	for(int indx = 0; indx< ship.length - 1; indx++){
		for (int indx1 = indx + 1; indx1 < ship.length; indx1++){
			if(ship[indx].address().compareTo(ship[indx1].address()) > 0){
				tempShip = ship[indx];
				ship[indx] = ship[indx1];
				ship[indx1] = tempShip;}
		}
	}
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static int findByNumber(int numberSearch, Shipping[] searchArray){
	int retIndx = -1;
	for(int indx = 0; indx < searchArray.length; indx++)
		if(searchArray[indx].referenceNumber() == numberSearch){
			retIndx = indx; break;}
	return retIndx;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void infoByNumber(PrintWriter rpt, int printSelection,Scanner keyboard, Shipping[] array){
	int searchNumber = 0;
	do{
		System.out.print("Enter a reference number to search for: ");
		searchNumber = keyboard.nextInt();
	}while(searchNumber <= 0);
	keyboard.nextLine(); // absorb the extra carriage return
	int indxReturned1 = findByNumber(searchNumber,array);
	if(indxReturned1 != -1)
		displayData(rpt,printSelection,array[indxReturned1]);
	else
		System.out.println("Reference number is not on file");
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static String getWeightClass(Shipping ship){
String result = "";
	if(ship.weightClass() == 1)
	result = "Light";
	else if(ship.weightClass() == 2)
		result = "Middle";
	else if(ship.weightClass() == 3)
	result = "Heavy";
	else if(ship.weightClass() == 4)
	result = "Over Weight";
	return result;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static String getSizeClass(Shipping ship){
String result = "";
	if(ship.sizeClass() == 1)
	result = "Small";
	else if(ship.sizeClass() == 2)
		result = "Medium";
	else if(ship.sizeClass() == 3)
	result = "Large";
	else if(ship.sizeClass() == 4)
	result = "Extra Large";
	return result;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static String getDeliveryZone(Shipping ship){
String result = "";
	if(ship.deliveryZone() == 10)
	result = "North";
	else if(ship.deliveryZone() == 20)
		result = "South";
	else if(ship.deliveryZone() == 30)
	result = "East";
	else if(ship.deliveryZone() == 40)
	result = "West";
	return result;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static double getWeightPrice(Shipping ship){
double result = 0.0;
	if(ship.weightClass() == 2)
	result = 10.00;
	else if(ship.weightClass() == 3)
	result = 20.00;
	else if(ship.weightClass() == 4)
	result = 35.00;
	return result;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static double getSizePrice(Shipping ship){
double result = 0.0;
	if(ship.sizeClass() == 2)
		result = 5.00;
	else if(ship.sizeClass() == 3)
	result = 10.00;
	else if(ship.sizeClass() == 4)
	result = 20.00;
	return result;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static double getDeliveryPrice(Shipping ship){
double result = 0.0;
	if(ship.deliveryZone() == 10)
	result = 25.00;
	else if(ship.deliveryZone() == 20)
		result = 30.00;
	else if(ship.deliveryZone() == 30)
	result = 40.00;
	else if(ship.deliveryZone() == 40)
	result = 50.00;
	return result;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static double cost(Shipping ship){
	return getWeightPrice(ship) + getSizePrice(ship) + getDeliveryPrice(ship);
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static double getTotal(Shipping[] shipArray){
double total = 0.0;
	for(int indx = 0; indx < shipArray.length; indx++)
	total += cost(shipArray[indx]);
	return total;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void displayTotal(PrintWriter rpt, int printSelection,Shipping[] ship){
	String fmtStr = "\n%-10s %-10s%-10s                                              $%-6.2f \n";
	writeToFile(rpt,printSelection,String.format(fmtStr,"Total ","","",getTotal(ship)));
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static int displayMenu(Scanner keyboard){
	int menuSelection = 0;
		do{
			System.out.println("1) Display unsorted report, 2) display report sorted by reference number, 3) display report sorted by address, 4) lookup item by reference number, 5) Exit ");
			menuSelection = keyboard.nextInt();
			if(menuSelection>5)
				System.out.println("invalid selection re-enter");
			} while(menuSelection>5);
	return menuSelection;
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
public static void displayMenuSelection(PrintWriter dataOut,int printSelection,Scanner keyboard,int menuSelection, Shipping[] ship){
	while(menuSelection !=5){
	if(menuSelection == 1){
		writeReport(dataOut,printSelection,ship);
		System.out.println("");}
	else if(menuSelection == 2){
		sortArrayByReference(ship);
		writeReport(dataOut,printSelection,ship);
		System.out.println("");}
	else if(menuSelection == 3){
		sortArrayByName(ship);
		writeReport(dataOut,printSelection,ship);
		System.out.println("");}
	else if(menuSelection == 4){
		infoByNumber(dataOut,printSelection,keyboard,ship);
		System.out.println("");}
		menuSelection = displayMenu(keyboard);
	}
}

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}