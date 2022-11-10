package cdZulieferer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import device.Device;

public class CdPlayer implements Device {
	private int volume = 0;
	
	@Override
	public void louder() {
		if(this.volume > 20) {
			System.out.println(this.volume--);
		} else {
			System.out.println("Loud enough!");
		}
		
	}

	@Override
	public void quieter() {
		if(this.volume < 1) {
			System.out.println(this.volume--);
		} else {
			System.out.println("Quiet enough!");
		}
		
	}

	@Override
	public int getVolume() {
		return this.volume;
	}

	@Override
	public void next() {
		System.out.println(this.getClass().getSimpleName() + " next");
		
	}

	@Override
	public void prev() {
		System.out.println(this.getClass().getSimpleName() + " previous");
		
	}

	@Override
	public String getInfoText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getOptions() {
		Class<?> myClass = this.getClass();
		
		Method[] myMethods = myClass.getDeclaredMethods();
		String [] options;
		if(myMethods != null) {
			options = new String[myMethods.length];
			for(int i = 0; i < myMethods.length; i++) {
				options[i] = myMethods[i].getName();
			}
		} else {
			options = new String[1];
			options[0] = "Keine Optionen Verfügbar";
		}
		return options;
	}

	@Override
	public void chooseOption(String opt) { // Funktioniert nicht richtig -> IDK how mit Invoke
		Method[] abc = this.getClass().getDeclaredMethods();
		for (Method options: abc) {
			if(opt.equals(options.getName())) {
				System.out.println(options.getName());
				System.out.println(opt);
				try {
					if(options.getParameterCount() == 0) {
						options.invoke(this);
					}
					
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	@Override
	public String play() {
		return this.getClass().getSimpleName() + " play";
	}
	

	public void eject() {
		
		System.out.println("CD wird ausgeworfen....");
		
	}
	
	public void inject() {
		
		System.out.println("CD wird geladen....");
		
	}
	
	public void showSongs() {
		
		System.out.println("Songliste: ........");
		
	}
	
	
	
	

}
