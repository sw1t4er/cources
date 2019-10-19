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

        /*
        String SQL_SELECT = "SELECT * FROM USERS";

        String urlM = "jdbc:postgresql://ec2-54-228-246-214.eu-west-1.compute.amazonaws.com/d79ut0j7jbh0ba";
        String userName = "vwevpkepmeqldn";
        String password = "0007c332efa7798831a5836a06d0a305e86c856308172613243a67bcd6feeb53";

        Properties dbProp = new Properties();
        dbProp.setProperty("jdbcUrl", urlM);
        dbProp.setProperty("username", userName);
        dbProp.setProperty("password", password);

        Yank.setupDataSource(dbProp);
        User user = Yank.queryBean(SQL_SELECT, User.class, null);
        user.toString();
        */
        /*
        Connection conn = null;

        String STRING_INSERT = "INSERT INTO public.users (id, email, first_name, gender, last_name, last_visit, locale, username, userpic) "+
                "VALUES ('56766', 'smasim2016@gmail.com4565', 'Maksym2', null, 'Skripay2', '2019-07-04 19:34:03.957000', 'ru', null, 'https://lh4.googleusercontent.com/-cynJQ5D4TQk/AAAAAAAAAAI/AAAAAAAABr4/vUDbM2NcbGk/photo.jpg')";

        try {
            conn = DriverManager.getConnection(urlM, "vwevpkepmeqldn", "0007c332efa7798831a5836a06d0a305e86c856308172613243a67bcd6feeb53");

            PreparedStatement preparedStatement = conn.prepareStatement(STRING_INSERT);
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /////////////////////////////////////////////

        List<User> result = new ArrayList<>();

        // auto close connection and preparedStatement
        try {
            conn = DriverManager.getConnection(urlM, "vwevpkepmeqldn", "0007c332efa7798831a5836a06d0a305e86c856308172613243a67bcd6feeb53");

            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String name = resultSet.getString("first_name");
                String last_nameM = resultSet.getString("last_name");
                String localeM = resultSet.getString("locale");
                //BigDecimal salary = resultSet.getBigDecimal("SALARY");
                //Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

                User obj = new User();
                obj.setId(id);
                obj.setFirstName(name);
                obj.setLastName(last_nameM);
                obj.setLocaleM(localeM);
                //obj.setSalary(salary);
                // Timestamp -> LocalDateTime
                //obj.setCreatedDate(createdDate.toLocalDateTime());

                result.add(obj);

            }
            result.forEach(x -> System.out.println(x));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
}
