package esisRepo.entity;

public class Repos {
    public int id;
    public String name;
    public User owner;

    public Repos(int idRepos, String nameRepos, User user){
        this.id = idRepos;
        this.name = nameRepos;
        this.owner = user;
    }


    public Repos() {
    }
}
