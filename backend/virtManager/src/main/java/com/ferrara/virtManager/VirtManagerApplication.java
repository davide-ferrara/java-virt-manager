package com.ferrara.virtManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*  
sudo apt update
sudo apt-get install qemu-system
sudo apt install libvirt-dev libvirt-daemon-system
sudo apt install libvirt-clients bridge-utils virt-manager

sudo adduser $USER libvirt

Verify that QEMU and libvirt are installed 
find /usr -name "libvirt.so*"
qemu-system-x86_64 --version 

systemctl status libvirtd
sudo systemctl start libvirtd

Activate the default network  
sudo virsh net-list --all
sudo virsh net-start default
*/

import org.libvirt.Connect;
import org.libvirt.LibvirtException;

@SpringBootApplication
public class VirtManagerApplication {

	public static void main(String[] args) {

		/*
		 * Connect conn = null;
		 * 
		 * try {
		 * conn = new Connect("qemu:///system", false);
		 * System.out.println("Connected to QEMU!");
		 * 
		 * long libv = conn.getVersion();
		 * System.out.println("Libvirt version is: " + libv);
		 * 
		 * String hostname = conn.getHostName();
		 * System.out.println("Hostname: " + hostname);
		 * 
		 * Qemu vm1 = new Qemu("VM1", 1048576, 1,
		 * "/var/lib/libvirt/images/alpine-standard-3.20.1-x86_64.iso");
		 * vm1.printXMLDesc();
		 * 
		 * conn.domainCreateXML(vm1.getXMLDesc(), 0);
		 * 
		 * } catch (LibvirtException e) {
		 * e.printStackTrace();
		 * }
		 * 
		 * try {
		 * conn.close();
		 * } catch (LibvirtException e) {
		 * System.out.println("Error closing connection: " + e);
		 * }
		 */

		Student s1 = new Student("Davide", "Ferrara", 518629);

		System.out.println(s1.toString());

		SpringApplication.run(VirtManagerApplication.class, args);

	}

}
