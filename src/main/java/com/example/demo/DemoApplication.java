package com.example.demo;

import com.example.demo.dao.ItemDao;
import com.example.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner, ItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter option: \n1 for insert, \n2 for delete,\n3 for select all," +
				"\n4 for update status, \nothers for end");
		String option = userInput.nextLine();

		switch(option) {
			case "1":
				System.out.println("Enter TODO:");
				String itemName1 = userInput.nextLine();
				Item newItem1 = new Item("sample",false);
				newItem1.setName(itemName1);
				insertItem(newItem1);
				break;
			case "2":
				System.out.println("Enter list name: ");
				String itemName2 = userInput.nextLine();
				deleteItemByName(itemName2);
				break;
			case "3":
				System.out.println(selectAllItem());
				break;
			case "4":
				System.out.println("Enter list name to mark as complete: ");
				String itemName4 = userInput.nextLine();
				Item newItem4 = new Item("sample",true);
				newItem4.setName(itemName4);
				updateItemStatus(newItem4);
				break;
			default:
				System.out.println("End operation.\n");
				option = "end";
		}

		if (option != "end") {
			run();
		}
	}

	@Override
	public int insertItem(Item item) {
		String sql = "INSERT INTO itemlist (name, status) VALUES (?, ?)";

		int result = jdbcTemplate.update(sql, item.getName(), item.isStatus());

		if (result > 0) {
			System.out.println("A new record has been inserted.");
			return 1;
		} else return 0;
	}

	@Override
	public List<Item> selectAllItem() {
		return jdbcTemplate.query("SELECT * FROM itemlist", new ResultSetExtractor<List<Item>>() {

			public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Item> itemDetailList = new ArrayList<Item>();
				while(rs.next()) {
					Item item = new Item();

					item.setName(rs.getString(1));
					item.setStatus(rs.getBoolean(2));
					itemDetailList.add(item);
				}
				return itemDetailList;
			}

		});
	}

	@Override
	public int deleteItemByName(String name) {
		String sql = "DELETE FROM itemlist WHERE name = (?)";

		int result = jdbcTemplate.update(sql, name);

		if (result > 0) {
			System.out.println("A record has been removed.");
			return 1;
		} else return 0;
	}

	@Override
	public int updateItemStatus(Item item) {
		String sql = "UPDATE itemlist SET status = (?) WHERE name = (?)";

		int result = jdbcTemplate.update(sql, true, item.getName());

		if (result > 0) {
			System.out.println("A record has been marked as complete.");
			return 1;
		} else return 0;
	}
}
