package util;

import java.text.ParseException;
import java.util.List;

import bo.User;
import bo.User8;

public abstract class Util {

	public static void mockList(List<User> users) {
		try {
			users.add(new User("Etienne", "Cassin", "01/03/2018"));
			users.add(new User("Valentin", "Grimoux", "21/04/2019"));
			users.add(new User("Yoan", "Forgeau", "02/12/2017"));
			users.add(new User("Quentin", "Forgeau", "02/12/2018"));
			users.add(new User("François", "Mauxion", "14/07/2018"));
			users.add(new User("Argann", "Bonneau", "19/03/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void mockList2(List<User8> users) {
		users.add(new User8("Etienne", "Cassin", "01/03/2018"));
		users.add(new User8("Valentin", "Grimoux", "21/04/2019"));
		users.add(new User8("Yoan", "Forgeau", "02/12/2017"));
		users.add(new User8("Quentin", "Forgeau", "02/12/2018"));
		users.add(new User8("François", "Mauxion", "14/07/2018"));
		users.add(new User8("Argann", "Bonneau", "19/03/2017"));
	}

}
