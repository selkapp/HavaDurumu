package com.ouz.springmvc;

public class TahminiSaatlikModel {
	private String ruzgarHizi;

    private String sicaklik;

    private String ruzgarYonu;

    private String maksimumRuzgarHizi;

    private String nem;

    private String tarih;

    private String hissedilenSicaklik;

    private String hadise;

    public String getRuzgarHizi ()
    {
        return ruzgarHizi;
    }

    public void setRuzgarHizi (String ruzgarHizi)
    {
        this.ruzgarHizi = ruzgarHizi;
    }

    public String getSicaklik ()
    {
        return sicaklik;
    }

    public void setSicaklik (String sicaklik)
    {
        this.sicaklik = sicaklik;
    }

    public String getRuzgarYonu ()
    {
        return ruzgarYonu;
    }

    public void setRuzgarYonu (String ruzgarYonu)
    {
        this.ruzgarYonu = ruzgarYonu;
    }

    public String getMaksimumRuzgarHizi ()
    {
        return maksimumRuzgarHizi;
    }

    public void setMaksimumRuzgarHizi (String maksimumRuzgarHizi)
    {
        this.maksimumRuzgarHizi = maksimumRuzgarHizi;
    }

    public String getNem ()
    {
        return nem;
    }

    public void setNem (String nem)
    {
        this.nem = nem;
    }

    public String getTarih ()
    {
        return tarih;
    }

    public void setTarih (String tarih)
    {
        this.tarih = tarih;
    }

    public String getHissedilenSicaklik ()
    {
        return hissedilenSicaklik;
    }

    public void setHissedilenSicaklik (String hissedilenSicaklik)
    {
        this.hissedilenSicaklik = hissedilenSicaklik;
    }

    public String getHadise ()
    {
        return hadise;
    }

    public void setHadise (String hadise)
    {
        this.hadise = hadise;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ruzgarHizi = "+ruzgarHizi+", sicaklik = "+sicaklik+", ruzgarYonu = "+ruzgarYonu+", maksimumRuzgarHizi = "+maksimumRuzgarHizi+", nem = "+nem+", tarih = "+tarih+", hissedilenSicaklik = "+hissedilenSicaklik+", hadise = "+hadise+"]";
    }
}
