package org.hyperskill.bluetooth;

public class SmartWatch extends MobileGadget {
    private int avgHeartRate;
    private Laptop connectedLaptop;

    public SmartWatch() {
        this.avgHeartRate = 75;
        this.connectedLaptop = new Laptop();
    }

    private int countHeartRate() {
        System.out.println("Counting heart rate");
        return avgHeartRate;
    }

    private void sendInfoLaptop(String data) {
        printNotification("Sending data to laptop : " + data);
        connectedLaptop.receiveInfo(data);
    }
}
