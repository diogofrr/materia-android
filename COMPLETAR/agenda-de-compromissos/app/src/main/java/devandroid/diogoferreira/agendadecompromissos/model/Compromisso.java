package devandroid.diogoferreira.agendadecompromissos.model;

public class Compromisso {
    private String title;
    private String description;
    private String date;
    private String hour;
    private String locale;

    public Compromisso(String title, String description, String date, String hour, String locale) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.hour = hour;
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "Compromisso{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}
