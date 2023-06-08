package Model.Guest;



public class mainTestGuest {
    public static void main(String[] args) {
        GuestModel guestModel = new GuestModel("localhost",8040,"Moshe");
        guestModel.connectHost();


    }
}
