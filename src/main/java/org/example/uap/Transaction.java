package org.example.uap;

public class Transaction {
    private String date;
    private double totalIncome;
    private double needs;
    private double wants;
    private double investment;
    private double charity;

    public Transaction(String date, double totalIncome, double needs, double wants, double investment, double charity) {
        this.date = date;
        this.totalIncome = totalIncome;
        this.needs = needs;
        this.wants = wants;
        this.investment = investment;
        this.charity = charity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getNeeds() {
        return needs;
    }

    public void setNeeds(double needs) {
        this.needs = needs;
    }

    public double getWants() {
        return wants;
    }

    public void setWants(double wants) {
        this.wants = wants;
    }

    public double getInvestment() {
        return investment;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    public double getCharity() {
        return charity;
    }

    public void setCharity(double charity) {
        this.charity = charity;
    }
}
