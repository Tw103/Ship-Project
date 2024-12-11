// Te'Variyae Woods


public class TimeConverter {
    private int hours;
    private int minutes;
    private int seconds;
    private boolean notPM; // True for AM, false for PM

    // Default constructor
    public TimeConverter() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.notPM = true; // AM
    }

    // Parameterized constructor
    public TimeConverter(int hours, int minutes, int seconds) throws TimeException {
        updateTime(hours, minutes, seconds);
    }

    // Accessors
    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }
    public int getSeconds() { return seconds; }
    public boolean isNotPM() { return notPM; }

    // Mutators
    public void setHours(int hours) throws TimeException {
        if (hours < 0 || hours > 23) throw new TimeException();
        this.hours = hours;
        updateAMPM();
    }

    public void setMinutes(int minutes) throws TimeException {
        if (minutes < 0 || minutes > 59) throw new TimeException();
        this.minutes = minutes;
    }
    
    public void setSeconds(int seconds) throws TimeException {
        if (seconds < 0 || seconds > 59) throw new TimeException();
        this.seconds = seconds;
    }

    private void updateAMPM() {
        if (hours == 0 || hours == 12) {
            notPM = true; // AM
        } else if (hours > 12) {
            hours -= 12;
            notPM = false; // PM
        } else {
            notPM = false; // PM
        }
        if (this.hours == 0) this.hours = 12; 
    }

    // Update time using three integers
    public void updateTime(int hours, int minutes, int seconds) throws TimeException {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
            throw new TimeException();
        }
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    // Update time using string
    public void updateTime(String time) throws TimeException {
        try {
            String[] parts = time.split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);
            updateTime(h, m, s);
        } catch (Exception e) {
            throw new TimeException();
        }
    }

    // Display time in 12 hour format
    public void displayTime() {
        String ampm = notPM ? "AM" : "PM";
        System.out.printf("%d:%02d:%02d %s%n", hours, minutes, seconds, ampm);
    }
}