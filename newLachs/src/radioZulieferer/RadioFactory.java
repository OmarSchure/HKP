package radioZulieferer;

import device.Device;
import device.DeviceFactory;

public class RadioFactory implements DeviceFactory {

	@Override
	public Device create() {
		// TODO Auto-generated method stub
		return new Radio();
	}

}
