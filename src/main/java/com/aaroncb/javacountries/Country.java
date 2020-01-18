package com.aaroncb.javacountries;

public class Country
{
    private String countryName;
    private int population;
    private int landMass;
    private int medianAge;

    public Country(String countryName, int population, int landMass, int medianAge) {
        this.countryName = countryName;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public Country(Country toClone)
    {
        this.countryName = toClone.getCountryName();
        this.population = toClone.getPopulation();
        this.landMass = toClone.getLandMass();
        this.medianAge = toClone.getMedianAge();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandMass() {
        return landMass;
    }

    public void setLandMass(int landMass) {
        this.landMass = landMass;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }
}
