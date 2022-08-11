package esisRepo.entity;

public class Owner {
    public String login;
    public int id;

    public Owner(){
    }

    public Owner(int id, String login){
        this.id =id;
        this.login = login;
    }
}
