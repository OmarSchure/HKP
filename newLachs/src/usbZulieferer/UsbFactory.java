package usbZulieferer;

import device.Device;
import device.DeviceFactory;

public class UsbFactory implements DeviceFactory{

	@Override
	public Device create() {
		// TODO Auto-generated method stub
		return new Usb();
	}

}
