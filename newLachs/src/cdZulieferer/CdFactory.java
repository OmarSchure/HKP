package cdZulieferer;

import device.Device;
import device.DeviceFactory;

public class CdFactory implements DeviceFactory{
	

	@Override
	public Device create() {
		// TODO Auto-generated method stub
		return new CdPlayer();
	}

}


