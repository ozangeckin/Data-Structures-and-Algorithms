import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * This class is the general class of users in the system. It contains general
 * information and functions for users.
 * 
 * @author ozan.geckin
 *
 */
public class User {

	private Integer userId;
	private String password;
	private String userName;
	private String role;
	private BufferedWriter bwu;
	private BufferedReader bru;

	/**
	 * No parameter constructor.
	 */
	public User() {

	}

	/**
	 * Two parameter constructor. It assigns the parameters it receives. Generated
	 * according to the rules within the user id and password
	 * 
	 * @param userName User user name
	 * @param role     User role
	 */
	public User(String userName, String role) {
		this.userId = genareteUserId();
		this.password = genarateUserPassword(userName);
		this.userName = userName;
		this.role = role;
	}

	/**
	 * Four parameter constructor. Creates a User with the parameters it receives.
	 * 
	 * @param userId   User id
	 * @param userName User name
	 * @param password User password
	 * @param role     User role
	 */
	public User(Integer userId, String userName, String password, String role) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.role = role;
	}
	
	/**
	 * Copy Constructor.I use it for assign transactions.
	 * @param other User 
	 */
	User(User other) {
		this.userId = other.userId;
		this.password = other.password;
		this.userName = other.userName;
		this.role = other.role;
	}

	/**
	 * This method writes the users' information to the user.txt file.
	 */
	public void writerFile() {
		try {
			bwu = new BufferedWriter(new FileWriter("data/user.txt", true));
			bwu.write(String.valueOf(this.userId));
			bwu.write(";");
			bwu.write(this.userName);
			bwu.write(";");
			bwu.write(this.password);
			bwu.write(";");
			bwu.write(this.role);
			bwu.write("\n");
			bwu.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method provide authenticate.
	 * @param UserId User id
	 * @param Pass User password
	 * @param role User role
	 * @return user User true
	 */
	public User Login(Integer UserId, String Pass, String role) {
		String temp;
		try {
			bru = new BufferedReader(new FileReader("data/user.txt"));
			bru.readLine();
			while ((temp = bru.readLine()) != null) {
				String[] token = temp.split(";");
				if (token[0] != null && token[2] != null) {
					if (UserId == Integer.parseInt(token[0]) && Pass.equals(token[2])) {
						if (role.equals("trader")) {
							return new Trader(userId, token[1], token[2], token[3]);
						} else {
							return new Customer();
						}
					}
				}
			}
			bru.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method generate User id
	 * @return int UserId
	 */
	public int genareteUserId() {
		int id = 0;
		int count = 0;
		LinkedList<Integer> idList = new LinkedList<Integer>();
		String temp, temp2;
		Random rd = new Random();
		id = 10000000 + rd.nextInt(90000000);
		try {
			bru = new BufferedReader(new FileReader("data/user.txt"));
			bru.readLine();
			while ((temp = bru.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(temp, ";");
				while (st.hasMoreElements()) {
					temp2 = st.nextToken();
					if (count == 0 && temp2 != null && temp2 != ";") {
						idList.add(Integer.parseInt(temp2));
					}
					count++;
				}
				count = 0;
			}
			bru.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (idList.contains(id)) {
			genareteUserId();
		}
		return id;
	}

	/**
	 * This method generate User password
	 * @param userName User name
	 * @return String password
	 */
	public String genarateUserPassword(String userName) {
		if (userName.length() < 6) {
			while (userName.length() < 6) {
				userName = userName + userName;
			}
		}
		return userName.substring(0, 6);
	}

	/**
	 * Getter for User id
	 * @return int User id
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * Getter for User password
	 * @return String User password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Getter for User name
	 * @return String User name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Getter for User role
	 * @return String User role
	 */
	public String getRole() {
		return role;
	}
}
