package lesson4.objects;

public class Computer {
	String type = "Laptop";
	String brand = "Dell";
	String model = "Vostro 3550";
	String display = "15.6 inch (1366x768) WXGA HD";
	String CPUName = "Intel Core i5-2520M";
	double CPUClockGHz = 2.50;
	String chipSet = "Intel Mobile HM67 Express";
	String graphicsCard = "ATI Mobility Radeon HD6630";
	int graphicsCardMemorySpaceGb = 1;
	String RAMtype = "DDR3-1333";
	int RAMSpaceGb = 4;
	String HDDBrand = "Western Digital";
	int HDDSpeed = 7200;
	int HDDSpaceGb = 500;
	String opticalDrive = "8x DVD+/-RW";
	String[] networkAdapter = {"Wi-Fi b/g/n", "Bluetooth", "Gigabit Ethernet"};
	String[] cardReader = {"SD", "MMC", "MS"};
	String webCamera = "2.0 MP";
	int USB2Qty = 2;
	int USB3Qty = 2;
	boolean isHDMI = true;
	boolean isESATA = true;
	boolean isFireWare = false;
	boolean isVGA = true;
	boolean isRG45 = true;
	boolean isRG11 = false;
	boolean isExpressCard = true;
	String battery = "6 cell Li-Ion 2.6 Ah";
	String OSName = "Windows 7 Ultimate SP1 64-bit";
	String[] addSoftware = new String[HDDSpaceGb];
	boolean isPowerOn = true;
	boolean isWiFiOn = true;
	boolean isBluetoothOn = true;
	boolean isDVDTrayOpen = false;
	
	void powerOn(boolean value) {}
	void wifiOn(boolean value) {}
	void bluetoothOn(boolean value) {}
	void dvdTrayOpen(boolean value) {}
	void printComputerInfo() {}
	int performanceEvaluation(double CPUClockGHz, int RAMSpaceGb,  int HDDSpeed) { return 0; }
	void upgrade(int newRAMSpaceGb, int newHDDSpaceGb) {}
	void replaceBattery(String newBattery) {}
	void reInstallOS(String newOSName) {} 
	void installNewAddSoftware(String newSoftware) {}
	void deinstallAddSoftware(String oldSoftware) {}
}
