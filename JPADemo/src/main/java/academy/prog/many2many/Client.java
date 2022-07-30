package academy.prog.many2many;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*

Cli   Co
id    id

Cli_co
client_id course_id


 */

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Oder",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public Client() {}

    public Client(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void addCourse(Product product) {
        products.add(product);
        product.getClients().add(this);
    }

    public void clearAddresses() {
        products.clear();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Product> getCourses() {
        return products;
    }

    public void setCourses(Set<Product> cours) {
        this.products = cours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(age, client.age) &&
                products.equals(client.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, products);
    }
}
