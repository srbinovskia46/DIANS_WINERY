package bootstrap;

import jakarta.annotation.PostConstruct;
import model.User;
import model.Winery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataHolder {
    public static List<Winery> wineries = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

@PostConstruct
 public void init() {
    wineries.add(new Winery((long)11111111,"Lazar",(long)111111111,(long)111111111));
  users.add(new User("svelj","pass123","fasf@yahoo.com"));

}

}