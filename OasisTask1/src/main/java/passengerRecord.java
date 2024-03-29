import java.util.Random;

public class passengerRecord {
    private static final int min = 1000;
    private static final int max = 9999;
    private  String  userName;
    private  String  password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int pnrNumber;
    private String passengerName;
    private String trainNumber;
    private String classType;
    private String journeyDate;
    private String from;
    private String to;

    public int getPrnNumber() {
        return pnrNumber;
    }

    public void setPrnNumber(int prnNumber) {
        this.pnrNumber = prnNumber;
    }

    public String getPassengerName() {

        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return pnrNumber + "\t\t\t" + passengerName + "\t\t\t" + trainNumber +"\t\t\t" +classType +"\t\t\t" +journeyDate + "\t\t\t" + from +"\t\t\t" + to;
    }
}
