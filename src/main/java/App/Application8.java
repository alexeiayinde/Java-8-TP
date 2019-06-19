package App;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bo.User;
import util.Util;

public class Application8 {

	public static void main(String[] args) {

		List<User> users = new ArrayList<>();
		Util.mockList(users);

		// Affichage de la liste des utilisateurs
		users.stream().forEach((user) -> System.out.println(user + "\n"));

		// Affichage d'un message avec nom + prenom, par ancienneté
		System.out.println("--------Liste des utilisateurs après tri selon date d'adhésion--------\n");
		users.stream().sorted((user1, user2) -> user1.getInscriptionDate().compareTo(user2.getInscriptionDate()))
				.forEach((user) -> System.out.println(user + "\n"));

		// Tri des utilisateurs par nom + prenom décroissant, limité aux 3 premiers
		// utilisateurs, si le nom contient 'A', passer le nom en majuscule
		System.out.println("--------Liste des utilisateurs après tri multiple--------\n");
		List<User> utilisateurs = users.stream().sorted((user1, user2) -> {
			int nomComp = user1.getLastName().compareTo(user2.getLastName());
			return (nomComp != 0) ? -nomComp : -user1.getFirstName().compareTo(user2.getFirstName());
		}).limit(3).map(user -> {
			if (user.getLastName().contains("a")) {
				user.setLastName(user.getLastName().toUpperCase());
			}
			return user;
		}).collect(Collectors.toList());

		utilisateurs.stream().forEach((user) -> System.out.println(user + "\n"));
	}

}
