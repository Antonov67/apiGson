package apiGson;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Valute {

    @SerializedName("Date")
    @Expose
    public String date;
    @SerializedName("PreviousDate")
    @Expose
    public String previousDate;
    @SerializedName("PreviousURL")
    @Expose
    public String previousURL;
    @SerializedName("Timestamp")
    @Expose
    public String timestamp;
    @SerializedName("Valute")
    @Expose
    public Valute__1 valute;

    @Override
    public String toString() {
        return "Valute{" +
                "date='" + date + '\'' +
                ", previousDate='" + previousDate + '\'' +
                ", previousURL='" + previousURL + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", valute=" + valute +
                '}';
    }
}

class Valute__1 {

    @SerializedName("USD")
    @Expose
    public Usd usd;

    @Override
    public String toString() {
        return "Valute__1{" +
                "usd=" + usd +
                '}';
    }
}
class Usd {

    @SerializedName("ID")
    @Expose
    public String id;
    @SerializedName("NumCode")
    @Expose
    public String numCode;
    @SerializedName("CharCode")
    @Expose
    public String charCode;
    @SerializedName("Nominal")
    @Expose
    public Integer nominal;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Value")
    @Expose
    public Double value;
    @SerializedName("Previous")
    @Expose
    public Double previous;

    @Override
    public String toString() {
        return "Usd{" +
                "id='" + id + '\'' +
                ", numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", previous=" + previous +
                '}';
    }
}