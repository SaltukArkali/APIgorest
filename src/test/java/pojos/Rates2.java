package pojos;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CAD",
        "HKD",
        "LVL",
        "PHP",
        "DKK",
        "HUF",
        "CZK",
        "AUD",
        "RON",
        "SEK",
        "IDR",
        "INR",
        "BRL",
        "RUB",
        "LTL",
        "JPY",
        "THB",
        "CHF",
        "SGD",
        "PLN",
        "BGN",
        "TRY",
        "CNY",
        "NOK",
        "NZD",
        "ZAR",
        "USD",
        "MXN",
        "EEK",
        "GBP",
        "KRW",
        "MYR",
        "HRK"
})
public class Rates2 {

    @JsonProperty("CAD")
    private Float cAD;
    @JsonProperty("HKD")
    private Float hKD;
    @JsonProperty("LVL")
    private Float lVL;
    @JsonProperty("PHP")
    private Float pHP;
    @JsonProperty("DKK")
    private Float dKK;
    @JsonProperty("HUF")
    private Float hUF;
    @JsonProperty("CZK")
    private Float cZK;
    @JsonProperty("AUD")
    private Float aUD;
    @JsonProperty("RON")
    private Float rON;
    @JsonProperty("SEK")
    private Float sEK;
    @JsonProperty("IDR")
    private Float iDR;
    @JsonProperty("INR")
    private Float iNR;
    @JsonProperty("BRL")
    private Float bRL;
    @JsonProperty("RUB")
    private Float rUB;
    @JsonProperty("LTL")
    private Float lTL;
    @JsonProperty("JPY")
    private Float jPY;
    @JsonProperty("THB")
    private Float tHB;
    @JsonProperty("CHF")
    private Float cHF;
    @JsonProperty("SGD")
    private Float sGD;
    @JsonProperty("PLN")
    private Float pLN;
    @JsonProperty("BGN")
    private Float bGN;
    @JsonProperty("TRY")
    private Float tRY;
    @JsonProperty("CNY")
    private Float cNY;
    @JsonProperty("NOK")
    private Float nOK;
    @JsonProperty("NZD")
    private Float nZD;
    @JsonProperty("ZAR")
    private Float zAR;
    @JsonProperty("USD")
    private Float uSD;
    @JsonProperty("MXN")
    private Float mXN;
    @JsonProperty("EEK")
    private Float eEK;
    @JsonProperty("GBP")
    private Float gBP;
    @JsonProperty("KRW")
    private Float kRW;
    @JsonProperty("MYR")
    private Float mYR;
    @JsonProperty("HRK")
    private Float hRK;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rates2() {
    }

    /**
     *
     * @param hKD
     * @param dKK
     * @param cAD
     * @param uSD
     * @param mYR
     * @param bGN
     * @param eEK
     * @param nOK
     * @param rON
     * @param sGD
     * @param cZK
     * @param sEK
     * @param nZD
     * @param bRL
     * @param cHF
     * @param hRK
     * @param mXN
     * @param lVL
     * @param lTL
     * @param zAR
     * @param iNR
     * @param tHB
     * @param cNY
     * @param aUD
     * @param kRW
     * @param jPY
     * @param pLN
     * @param gBP
     * @param iDR
     * @param hUF
     * @param pHP
     * @param tRY
     * @param rUB
     */
    public Rates2(Float cAD, Float hKD, Float lVL, Float pHP, Float dKK, Float hUF, Float cZK, Float aUD, Float rON, Float sEK, Float iDR, Float iNR, Float bRL, Float rUB, Float lTL, Float jPY, Float tHB, Float cHF, Float sGD, Float pLN, Float bGN, Float tRY, Float cNY, Float nOK, Float nZD, Float zAR, Float uSD, Float mXN, Float eEK, Float gBP, Float kRW, Float mYR, Float hRK) {
        super();
        this.cAD = cAD;
        this.hKD = hKD;
        this.lVL = lVL;
        this.pHP = pHP;
        this.dKK = dKK;
        this.hUF = hUF;
        this.cZK = cZK;
        this.aUD = aUD;
        this.rON = rON;
        this.sEK = sEK;
        this.iDR = iDR;
        this.iNR = iNR;
        this.bRL = bRL;
        this.rUB = rUB;
        this.lTL = lTL;
        this.jPY = jPY;
        this.tHB = tHB;
        this.cHF = cHF;
        this.sGD = sGD;
        this.pLN = pLN;
        this.bGN = bGN;
        this.tRY = tRY;
        this.cNY = cNY;
        this.nOK = nOK;
        this.nZD = nZD;
        this.zAR = zAR;
        this.uSD = uSD;
        this.mXN = mXN;
        this.eEK = eEK;
        this.gBP = gBP;
        this.kRW = kRW;
        this.mYR = mYR;
        this.hRK = hRK;
    }

    @JsonProperty("CAD")
    public Float getCAD() {
        return cAD;
    }

    @JsonProperty("CAD")
    public void setCAD(Float cAD) {
        this.cAD = cAD;
    }

    @JsonProperty("HKD")
    public Float getHKD() {
        return hKD;
    }

    @JsonProperty("HKD")
    public void setHKD(Float hKD) {
        this.hKD = hKD;
    }

    @JsonProperty("LVL")
    public Float getLVL() {
        return lVL;
    }

    @JsonProperty("LVL")
    public void setLVL(Float lVL) {
        this.lVL = lVL;
    }

    @JsonProperty("PHP")
    public Float getPHP() {
        return pHP;
    }

    @JsonProperty("PHP")
    public void setPHP(Float pHP) {
        this.pHP = pHP;
    }

    @JsonProperty("DKK")
    public Float getDKK() {
        return dKK;
    }

    @JsonProperty("DKK")
    public void setDKK(Float dKK) {
        this.dKK = dKK;
    }

    @JsonProperty("HUF")
    public Float getHUF() {
        return hUF;
    }

    @JsonProperty("HUF")
    public void setHUF(Float hUF) {
        this.hUF = hUF;
    }

    @JsonProperty("CZK")
    public Float getCZK() {
        return cZK;
    }

    @JsonProperty("CZK")
    public void setCZK(Float cZK) {
        this.cZK = cZK;
    }

    @JsonProperty("AUD")
    public Float getAUD() {
        return aUD;
    }

    @JsonProperty("AUD")
    public void setAUD(Float aUD) {
        this.aUD = aUD;
    }

    @JsonProperty("RON")
    public Float getRON() {
        return rON;
    }

    @JsonProperty("RON")
    public void setRON(Float rON) {
        this.rON = rON;
    }

    @JsonProperty("SEK")
    public Float getSEK() {
        return sEK;
    }

    @JsonProperty("SEK")
    public void setSEK(Float sEK) {
        this.sEK = sEK;
    }

    @JsonProperty("IDR")
    public Float getIDR() {
        return iDR;
    }

    @JsonProperty("IDR")
    public void setIDR(Float iDR) {
        this.iDR = iDR;
    }

    @JsonProperty("INR")
    public Float getINR() {
        return iNR;
    }

    @JsonProperty("INR")
    public void setINR(Float iNR) {
        this.iNR = iNR;
    }

    @JsonProperty("BRL")
    public Float getBRL() {
        return bRL;
    }

    @JsonProperty("BRL")
    public void setBRL(Float bRL) {
        this.bRL = bRL;
    }

    @JsonProperty("RUB")
    public Float getRUB() {
        return rUB;
    }

    @JsonProperty("RUB")
    public void setRUB(Float rUB) {
        this.rUB = rUB;
    }

    @JsonProperty("LTL")
    public Float getLTL() {
        return lTL;
    }

    @JsonProperty("LTL")
    public void setLTL(Float lTL) {
        this.lTL = lTL;
    }

    @JsonProperty("JPY")
    public Float getJPY() {
        return jPY;
    }

    @JsonProperty("JPY")
    public void setJPY(Float jPY) {
        this.jPY = jPY;
    }

    @JsonProperty("THB")
    public Float getTHB() {
        return tHB;
    }

    @JsonProperty("THB")
    public void setTHB(Float tHB) {
        this.tHB = tHB;
    }

    @JsonProperty("CHF")
    public Float getCHF() {
        return cHF;
    }

    @JsonProperty("CHF")
    public void setCHF(Float cHF) {
        this.cHF = cHF;
    }

    @JsonProperty("SGD")
    public Float getSGD() {
        return sGD;
    }

    @JsonProperty("SGD")
    public void setSGD(Float sGD) {
        this.sGD = sGD;
    }

    @JsonProperty("PLN")
    public Float getPLN() {
        return pLN;
    }

    @JsonProperty("PLN")
    public void setPLN(Float pLN) {
        this.pLN = pLN;
    }

    @JsonProperty("BGN")
    public Float getBGN() {
        return bGN;
    }

    @JsonProperty("BGN")
    public void setBGN(Float bGN) {
        this.bGN = bGN;
    }

    @JsonProperty("TRY")
    public Float getTRY() {
        return tRY;
    }

    @JsonProperty("TRY")
    public void setTRY(Float tRY) {
        this.tRY = tRY;
    }

    @JsonProperty("CNY")
    public Float getCNY() {
        return cNY;
    }

    @JsonProperty("CNY")
    public void setCNY(Float cNY) {
        this.cNY = cNY;
    }

    @JsonProperty("NOK")
    public Float getNOK() {
        return nOK;
    }

    @JsonProperty("NOK")
    public void setNOK(Float nOK) {
        this.nOK = nOK;
    }

    @JsonProperty("NZD")
    public Float getNZD() {
        return nZD;
    }

    @JsonProperty("NZD")
    public void setNZD(Float nZD) {
        this.nZD = nZD;
    }

    @JsonProperty("ZAR")
    public Float getZAR() {
        return zAR;
    }

    @JsonProperty("ZAR")
    public void setZAR(Float zAR) {
        this.zAR = zAR;
    }

    @JsonProperty("USD")
    public Float getUSD() {
        return uSD;
    }

    @JsonProperty("USD")
    public void setUSD(Float uSD) {
        this.uSD = uSD;
    }

    @JsonProperty("MXN")
    public Float getMXN() {
        return mXN;
    }

    @JsonProperty("MXN")
    public void setMXN(Float mXN) {
        this.mXN = mXN;
    }

    @JsonProperty("EEK")
    public Float getEEK() {
        return eEK;
    }

    @JsonProperty("EEK")
    public void setEEK(Float eEK) {
        this.eEK = eEK;
    }

    @JsonProperty("GBP")
    public Float getGBP() {
        return gBP;
    }

    @JsonProperty("GBP")
    public void setGBP(Float gBP) {
        this.gBP = gBP;
    }

    @JsonProperty("KRW")
    public Float getKRW() {
        return kRW;
    }

    @JsonProperty("KRW")
    public void setKRW(Float kRW) {
        this.kRW = kRW;
    }

    @JsonProperty("MYR")
    public Float getMYR() {
        return mYR;
    }

    @JsonProperty("MYR")
    public void setMYR(Float mYR) {
        this.mYR = mYR;
    }

    @JsonProperty("HRK")
    public Float getHRK() {
        return hRK;
    }

    @JsonProperty("HRK")
    public void setHRK(Float hRK) {
        this.hRK = hRK;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cAD", cAD).append("hKD", hKD).append("lVL", lVL).append("pHP", pHP).append("dKK", dKK).append("hUF", hUF).append("cZK", cZK).append("aUD", aUD).append("rON", rON).append("sEK", sEK).append("iDR", iDR).append("iNR", iNR).append("bRL", bRL).append("rUB", rUB).append("lTL", lTL).append("jPY", jPY).append("tHB", tHB).append("cHF", cHF).append("sGD", sGD).append("pLN", pLN).append("bGN", bGN).append("tRY", tRY).append("cNY", cNY).append("nOK", nOK).append("nZD", nZD).append("zAR", zAR).append("uSD", uSD).append("mXN", mXN).append("eEK", eEK).append("gBP", gBP).append("kRW", kRW).append("mYR", mYR).append("hRK", hRK).toString();
    }

}