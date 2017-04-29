package javapractise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author vikky.agrawal
 * 
 */

class Animal {

	int i;
}

class Dog extends Animal implements Serializable {
	private static final long serialVersionUID = 32858563L;

	Dog(String name, int k) {
		this.name = name;
		this.k = k;
	}

	static int j = 9;
	private int k;

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name = "Viks";

	private void writeObject(ObjectOutputStream os) throws IOException {
		os.defaultWriteObject();
		os.writeInt(this.getK());

	}
	
	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
			
	}

}

public class SerializeTest{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Dog d = new Dog("Fido", 35);
		Dog deserialized = null;
		Dog.j=10;
		System.out.println("before: " + d.getName() + " " + d.getK());
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			deserialized = (Dog) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after: " + d.getName() + " " + d.getK()+" static variable :"+deserialized.j);

	}

}
