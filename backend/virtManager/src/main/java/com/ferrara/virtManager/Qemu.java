package com.ferrara.virtManager;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.IllegalNameException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Qemu {

    private String name;
    private int memorySize;
    private String memoryUnit;
    private String placement;
    private int vcpu;
    private String osArch;
    private String osMachine;
    private String osType;
    private String osBootDev;
    private String diskDriverName;
    private String diskDriverType;
    private String diskSource;
    private String macAddr;
    private int vncPort;
    private String vncAddr;

    private String XMLDesc;

    public Qemu(String name, int memorySize, int vcpu, String osImagePath) {
        this.name = name;
        this.memorySize = memorySize;
        this.diskSource = osImagePath;
        this.memoryUnit = "KiB";
        this.placement = "static";
        this.vcpu = vcpu;
        this.osArch = "x86_64";
        this.osMachine = "pc-i440fx-2.0";
        this.osType = "hvm";
        this.osBootDev = "hd";
        this.diskDriverName = "qemu";
        this.diskDriverType = "raw";
        this.macAddr = "52:54:00:00:00:00";
        this.vncPort = 5900;
        this.vncAddr = "127.0.0.1";

        // After all istance variables are initialized
        this.XMLDesc = this.createXMLDesc();
    }

    public String getXMLDesc() {
        return this.XMLDesc;
    }

    public void printXMLDesc() {
        System.out.println(this.XMLDesc);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.XMLDesc = this.createXMLDesc();
    }

    private String createXMLDesc() throws IllegalNameException {
        Document doc = new Document();

        Element root = new Element("domain");
        root.setAttribute("type", "kvm");

        Element nameEl = new Element("name");
        nameEl.setText(this.name);

        Element memoryEl = new Element("memory");
        memoryEl.setText(String.valueOf(this.memorySize));
        memoryEl.setAttribute("unit", this.memoryUnit);

        Element vcpuEl = new Element("vcpu");
        vcpuEl.setText(String.valueOf(this.vcpu));
        vcpuEl.setAttribute("placement", this.placement);

        Element osEl = new Element("os");

        Element typeEl = new Element("type");
        typeEl.setAttribute("arch", this.osArch);
        typeEl.setAttribute("machine", this.osMachine);
        typeEl.setText(this.osType);

        Element bootEl = new Element("boot");
        bootEl.setAttribute("dev", this.osBootDev);

        osEl.addContent(typeEl);
        osEl.addContent(bootEl);

        Element devicesEl = new Element("devices");

        Element diskEl = new Element("disk");
        diskEl.setAttribute("type", "file");
        diskEl.setAttribute("device", "disk");

        Element driverEl = new Element("driver");
        driverEl.setAttribute("name", this.diskDriverName);
        driverEl.setAttribute("type", this.diskDriverType);

        Element sourceEl = new Element("source");
        sourceEl.setAttribute("file", this.diskSource);

        Element targetEl = new Element("target");
        targetEl.setAttribute("dev", "vda");
        targetEl.setAttribute("bus", "virtio");

        diskEl.addContent(driverEl);
        diskEl.addContent(sourceEl);
        diskEl.addContent(targetEl);

        Element interfaceEl = new Element("interface");
        interfaceEl.setAttribute("type", "network");

        Element macEl = new Element("mac");
        macEl.setAttribute("address", this.macAddr);

        Element sourceNetEl = new Element("source");
        sourceNetEl.setAttribute("network", "default");

        Element modelEl = new Element("model");
        modelEl.setAttribute("type", "virtio");

        interfaceEl.addContent(macEl);
        interfaceEl.addContent(sourceNetEl);
        interfaceEl.addContent(modelEl);

        Element graphicsEl = new Element("graphics");
        graphicsEl.setAttribute("type", "vnc");
        graphicsEl.setAttribute("autoport", "false");
        graphicsEl.setAttribute("port", String.valueOf(this.vncPort));
        graphicsEl.setAttribute("listen", this.vncAddr);

        Element listenEl = new Element("listen");
        listenEl.setAttribute("type", "address");
        listenEl.setAttribute("address", this.vncAddr);

        Element videoEl = new Element("video");

        Element modelVideoEl = new Element("model");
        modelVideoEl.setAttribute("type", "cirrus");

        videoEl.addContent(modelVideoEl);
        devicesEl.addContent(diskEl);
        devicesEl.addContent(interfaceEl);
        devicesEl.addContent(graphicsEl);
        graphicsEl.addContent(listenEl);
        devicesEl.addContent(videoEl);

        root.addContent(nameEl);
        root.addContent(memoryEl);
        root.addContent(vcpuEl);
        root.addContent(osEl);
        root.addContent(devicesEl);

        doc.setRootElement(root);

        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.setFormat(Format.getPrettyFormat());
        return xmlOutputter.outputString(doc);
    }

}
