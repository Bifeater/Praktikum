/* (C) 2016, Gudrun Schiedermeier, gschied@haw-landshut.de
 * Oracle Corporation Java 1.8.0_72, Linux i386 4.4.0
 * mozart (Intel Core i7-4600U CPU/2701 MHz, 4 Cores, 11776 MB RAM)
 */

package werbeagentur;

import java.util.Objects;

/**Repraesentiert eine Firma.
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2016-10-13
 */
public class Corporation {


	private final String name;


	private String address;


	public Corporation(String name, String address) {
		this.name = Objects.requireNonNull(name);
		this.address = Objects.requireNonNull(address);
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Corporation [name=" + name + ", address=" + address + "]";
	}

}
