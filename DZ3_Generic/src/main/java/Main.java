import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

    public class Main {
        public static void main(String[] args) {
            List<User> userList=new ArrayList<>();
            userList.add(new User("name1",20));
            userList.add(new User("name2",25));
            userList.add(new User("name3",30));
            userList.add(new User("name4",35));
            userList.add(new User("name5",40));
            userList.add(new User("name6",45));
            userList.add(new User("name7",50));
            userList.add(new User("name8",55));
//          userList.stream().filter(user->user.getAge()>30&&user.getAge()<45).forEach(user-> System.out.println(user));
//          userList=userList.stream().filter(user->user.getAge()>30&&user.getAge()<45).collect(Collectors.toList());
            System.out.println(userList.stream().map(user -> user.getName()).collect(Collectors.toList()));
        }
    }