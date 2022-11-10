package bordcomputer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import device.Device;

public class Bordcomputer {
	
	private String[] deviceName ;
	private Device[] installedDevices ;
	private Device playingDevice;
	//private String datName = "Z:\\AI\\fdai6291\\eclipse_HKdP\\newLachs\\src\\bordcomputer\\Geraete.config";
//	private String datName = "..\\newLachs\\src\\bordcomputer\\Geraete.config";
	private String datName = "..\\newLachs\\src\\bordcomputer\\Geraete.config";
	

	
	 public Bordcomputer(Device[] toInstDevices) {
		int i = 0;
		
		for(Device d : toInstDevices) {
			installedDevices[i] = d;
			i++;
		}
		playingDevice = installedDevices[0];
		
	}
	public void readConfig()   {

		File file = new File(datName);
        if (!file.canRead() || !file.isFile())
            System.exit(0);

        BufferedReader in = null;
        try {
        	String[] deviceNameTmp = new String[3];
        	String [] splitRow;
            in = new BufferedReader(new FileReader(datName));
            String zeile = null;
            int i = 0;
            while ((zeile = in.readLine()) != null) {
            	splitRow = zeile.split("/s");
            	deviceNameTmp[i] = splitRow[2];  
                i++;
                }
            deviceName = new String[i];
            installedDevices = new Device[i];
            i = 0;
            while(i < deviceName.length) {
            	deviceName[i] = deviceNameTmp[i];
            	i++;
            	
            }
            System.out.println(Arrays.toString(deviceName));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
	}
	
	
	public void setDevices() {
		
//		Lösung Aufgabe 2
//		installedDevices[0] = new Radio();
//		installedDevices[1] = new CdPlayer();
//		installedDevices[2] = new Usb();
	
		
//		Lösung Aufgabe 1		
//		try {
//			if(installedDevices != null) {
//				for(int i = 0; i < deviceName.length; i++) {
//				
//					Class<?> deviceClass = Class.forName("bordcomputer." + deviceName[i]);
//					Constructor<?> deviceConst = deviceClass.getConstructor();
//					installedDevices[i] = (Device) deviceConst.newInstance();
//					
//				}
//				if(installedDevices[0] != null) playingDevice = installedDevices[0];
//				
//			}
//
//		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
		
	}
	
	public void shutdown() {
		System.out.println("System: " + this.getClass().getName() + " wird heruntergefahren!");
	}
	
	public void changeDevice() {
		int i = 0;
		for(Device d : installedDevices) {
			if(d.getClass().getName().equals(playingDevice.getClass().getName())) {
				playingDevice = installedDevices[++i % 3];
				break;
			}
			i++;
		}
		
		
		System.out.println(playingDevice.getClass().getSimpleName());
	}
	public void louder(int p) {
		playingDevice.louder();
	}
	
	public void quieter(int p) {
		playingDevice.quieter();
		//ruft Device
	}
	
	public void showVolume() {
		playingDevice.getVolume();
	}
	
	public void next() {
		playingDevice.next();
	}
	
	public void prev() {
		playingDevice.prev();
	}
	
	public void play() {
		System.out.println(playingDevice.play());
	}

	


	
	public void enterOption(String choice) {
		playingDevice.chooseOption(choice);
		
	}

	
	public void showOptions() {
		for (String options: playingDevice.getOptions()) {
		    System.out.println(options);
		}
		
	}
	
	

}
