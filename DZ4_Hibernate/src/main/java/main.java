import model.Address;
import model.Good;
import model.User;
import service.Service;
import java.util.Collection;
import java.util.LinkedList;

public class main {

    // требует инстялляции плагина lombok

    public static void main(String[] args) {
        //Dao<User> dao=new Dao<>(User.class);
        Service<User> userService=new Service<>(User.class);
        Service<Good> goodService=new Service<>(Good.class);
        Service<Address> addressService=new Service<>(Address.class);
        //UserService userService = new UserService();
        //GoodService goodService = new GoodService();
        //AddressService addressService = new AddressService();

        User anton = new User();
        Collection<Good> basket = new LinkedList<Good>() {{
            add(goodService.findById(Long.valueOf(2)));
            add(goodService.findById(Long.valueOf(4)));
            add(goodService.findById(Long.valueOf(6)));
            add(goodService.findById(Long.valueOf(6)));
        }};
        anton.setFirstName("Anton");
        anton.setLastName("Anton'ch");
        anton.setLocale("ua");
        anton.setBasket(basket);
        userService.save(anton);

        addressService.save(new Address(anton, "Maup 123", "12345"));
        System.out.println(userService.findAll());
        System.out.println("Addresses:\n" + addressService.findAll());
    }
}
