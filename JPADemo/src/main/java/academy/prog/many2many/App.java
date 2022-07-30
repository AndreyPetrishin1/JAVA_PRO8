package academy.prog.many2many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {

        try {
            // create connection
            emf = Persistence.createEntityManagerFactory("JPAOrder");
            em = emf.createEntityManager();

            try {

                Client client1 = new Client("Andrey", 35);
                Client client2 = new Client("Vika", 28);

                Product product1 = new Product("Phone", 123L);
                Product product2 = new Product("Desctop", 34543L);



                
                client1.addCourse(product1);

                client1.addCourse(product2);

                product1.addClient(client2);


                em.getTransaction().begin();
                try {

                    em.persist(client1);
                    em.persist(client2);

                    em.getTransaction().commit();
                } catch (Exception ex) {
                    em.getTransaction().rollback();
                }
                //
            } finally {

                em.close();
                emf.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

    }

}
