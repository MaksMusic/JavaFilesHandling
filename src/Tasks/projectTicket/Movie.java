package Tasks.projectTicket;

public enum Movie {
    Doom(400,800),
    Boom(250,500),
    Halk(700,1200),
    Help(100,300),
    Ridick(900,1700);

    Movie(int priceDay,int priceEvening) {
        this.priceEvening = priceEvening;
        this.priceDay = priceDay;
    }

    private int priceDay;
    private int priceEvening;

    public int getPriceDay() {
        return priceDay;
    }

    public int getPriceEvening() {
        return priceEvening;
    }
}
