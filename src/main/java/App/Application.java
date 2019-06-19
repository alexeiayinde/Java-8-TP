package App;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bo.User;
import bo.User8;
import util.Util;

public class Application {

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)
			executeJ7();
		long t2 = System.currentTimeMillis();
		System.out.println("\nLe temps d'exécution J7 (10 runs) est de : " + (t2 - t1) + " ms.\n");

		System.out.println("----------APPLICATION J8----------\n");
		long t3 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)
			executeJ8();
		long t4 = System.currentTimeMillis();

		System.out.println("\nTEST DE PERFORMANCE (10000 runs)\n");
		System.out.println(" - Le temps d'exécution J7 est de : " + (t2 - t1) + " ms");
		System.out.println(" - Le temps d'exécution J8 est de : " + (t4 - t3) + " ms");
	}

	public static void executeJ7() {
		List<User> users = new ArrayList<>();
		Util.mockList(users);

		// Affichage de la liste des utilisateurs
		for (User user : users) {
			System.out.println(user + "\n");
		}

		// Affichage d'un message avec nom + prenom, par ancienneté
		users.sort(new Comparator<User>() {
			@Override
			public int compare(User user1, User user2) {
				int nomComp = user1.getInscriptionDate().compareTo(user2.getInscriptionDate());
				return nomComp;
			}
		});
		System.out.println("--------Liste des utilisateurs après tri selon date d'adhésion--------\n");
		for (User user : users) {
			System.out.println(user + "\n");
		}

		// Tri des utilisateurs par nom + prenom décroissant, limité aux 3 premiers
		// utilisateurs, si le nom contient 'A', passer le nom en majuscule
		users.sort(new Comparator<User>() {
			@Override
			public int compare(User user1, User user2) {
				int nomComp = user1.getLastName().compareTo(user2.getLastName());
				return (nomComp != 0) ? -nomComp : -user1.getFirstName().compareTo(user2.getFirstName());
			}
		});
		System.out.println("--------Liste des utilisateurs après tri multiple--------\n");
		for (int i = 0; i < 3; i++) {
			if (i < users.size()) {
				if (users.get(i).getLastName().contains("a")) {
					users.get(i).setLastName(users.get(i).getLastName().toUpperCase());
				}
			}
		}
		for (User user : users) {
			System.out.println(user + "\n");
		}
	}

	public static void executeJ8() {
		List<User8> users = new ArrayList<>();
		Util.mockList2(users);

		// Affichage de la liste des utilisateurs
		users.stream().forEach((user) -> System.out.println(user + "\n"));

		// Affichage d'un message avec nom + prenom, par ancienneté
		System.out.println("--------Liste des utilisateurs après tri selon date d'adhésion--------\n");
		users.stream().sorted((user1, user2) -> user1.getInscriptionDate().compareTo(user2.getInscriptionDate()))
				.forEach((user) -> System.out.println(user + "\n"));

		// Tri des utilisateurs par nom + prenom décroissant, limité aux 3 premiers
		// utilisateurs, si le nom contient 'A', passer le nom en majuscule
		System.out.println("--------Liste des utilisateurs après tri multiple--------\n");
		List<User8> utilisateurs = users.stream().sorted((user1, user2) -> {
			int nomComp = user1.getLastName().compareTo(user2.getLastName());
			return (nomComp != 0) ? -nomComp : -user1.getFirstName().compareTo(user2.getFirstName());
		}).limit(3).map(user -> {
			if (user.getLastName().contains("a")) {
				user.setLastName(user.getLastName().toUpperCase());
			}
			return user;
		}).collect(Collectors.toList());

		users.stream().forEach((user) -> System.out.println(user + "\n"));
	}
}
