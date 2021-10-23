package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente();
		Cliente cliente2 = new Cliente();
				
		
		cliente.setNombre("pepe");

		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
		
		while (opcion!=5) {
			System.out.println("1. Crear Cliente");
			System.out.println("2. Buscar Cliente");
			System.out.println("3. Actualizar Cliente");
			System.out.println("4. Eliminar Cliente");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Digite el nombre del cliente:");
				cliente = new Cliente();
				cliente.setId(null);
				scanner.nextLine();
				cliente.setNombre(scanner.nextLine());

				System.out.println("Digite el nombre del cliente:");
				cliente.setNombre(scanner.toString());
				System.out.println(cliente);
				entity.getTransaction().begin();
				entity.persist(cliente);
				entity.getTransaction().commit();
				System.out.println("Cliente registrado..");
				System.out.println();
				break;

			case 2:
				System.out.println("Digite el id del cliente a buscar:");
				cliente = new Cliente();
				cliente = entity.find(Cliente.class, scanner.nextLong());
				if (cliente != null) {
					System.out.println(cliente);
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Cliente no encontrado... Lista de productos completa");
					List<Cliente> listaProductos= new ArrayList<>();
					Query query=entity.createQuery("SELECT p FROM clientes p");
					listaProductos=query.getResultList();
					for (Cliente p : listaProductos) {
						System.out.println(p);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el id del Cliente a actualizar:");
				cliente = new Cliente();

				cliente = entity.find(Cliente.class, scanner.nextLong());
				if (cliente != null) {
					System.out.println(cliente);
					System.out.println("Digite el nombre del Cliente:");
					scanner.nextLine();
					cliente.setNombre(scanner.nextLine());
					entity.getTransaction().begin();
					entity.merge(cliente);
					entity.getTransaction().commit();
					System.out.println("Producto actualizado..");
					System.out.println();
				} else {
					System.out.println("Producto no encontrado....");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del Cliente a eliminar:");
				cliente = new Cliente();

				cliente = entity.find(Cliente.class, scanner.nextLong());
				if (cliente != null) {
					System.out.println(cliente);
					entity.getTransaction().begin();
					entity.remove(cliente);
					entity.getTransaction().commit();
					System.out.println("Cliente eliminado...");
				} else {
					System.out.println("Cliente no encontrado...");
				}
				break;
			case 5:entity.close();JPAUtil.shutdown();
			break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
		}
	}

}