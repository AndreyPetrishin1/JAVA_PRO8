package academy.prog.many2many;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long Price;

    @ManyToMany(mappedBy = "products")
    private Set<Client> clients = new HashSet<>();

    public Product() {
    }

    public Product(String name, Long price) {
        this.name = name;
        Price = price;
    }

    public void addClient(Client client) {
        clients.add(client);
        client.getCourses().add(this);
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
