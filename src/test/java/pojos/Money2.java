package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "rates",
        "base",
        "date"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class Money2 {

    @JsonProperty("rates")
    private Rates rates;
    @JsonProperty("base")
    private String base;
    @JsonProperty("date")
    private String date;

    /**
     * No args constructor for use in serialization
     *
     */
    public Money2() {
    }

    /**
     *
     * @param date
     * @param rates
     * @param base
     */
    public Money2(Rates rates, String base, String date) {
        super();
        this.rates = rates;
        this.base = base;
        this.date = date;
    }

    @JsonProperty("rates")
    public Rates getRates() {
        return rates;
    }

    @JsonProperty("rates")
    public void setRates(Rates rates) {
        this.rates = rates;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rates", rates).append("base", base).append("date", date).toString();
    }

}