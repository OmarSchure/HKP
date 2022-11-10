package integratorPack;

import bordcomputer.Bordcomputer;
import cdZulieferer.CdPlayer;
import device.Device;
import radioZulieferer.Radio;
import usbZulieferer.Usb;

public class Integrator {
	
	public static void main(String[] args) {
		Device[] toInstallDevices = new Device[3];
		
		
		toInstallDevices[0] = new CdPlayer();
		toInstallDevices[1] = new Radio();
		toInstallDevices[2] = new Usb();
		Bordcomputer ab = new Bordcomputer(toInstallDevices);
		ab.readConfig();
		ab.setDevices();
		ab.showOptions();
		ab.enterOption("louder");
		ab.changeDevice();
		ab.changeDevice();
		ab.changeDevice();
		ab.changeDevice();
	}

}
