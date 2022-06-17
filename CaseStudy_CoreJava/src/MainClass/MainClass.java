package MainClass;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import SortOrderBasedOnValue.SortOrderBasedOnValue;
import casestudy.exceptions.InvalidCategryException;
import casestudy.model.Order;
import casestudy.service.IOrderService;

public class MainClass implements IOrderService {

	Scanner sc = new Scanner(System.in);
	Scanner stringScanner = new Scanner(System.in);

	public static void main(String[] args) {

		MainClass app = new MainClass();

		while (true) {
			System.out.println("\n\n ------------------------\n");
			System.out.println("1. Orders By Category");
			System.out.println("2. Total Order Cost");
			System.out.println("3. Cancelled Orders");
			System.out.println("4. Create Order Map ");
			System.out.println("5. filter Orders");
			System.out.println("6. Orders Based On Order Value");
			System.out.println("7. Generate Report");
			System.out.println("Enter User Choice :- ");
			int choice = app.sc.nextInt();

			switch (choice) {
			case 1:
				try {
					app.getAllOrdersByCategory(null);
				} catch (InvalidCategryException e) {

					e.printStackTrace();
				}
				break;

			case 2:
				try {
					app.getTotalOrderCost(null);
				} catch (InvalidCategryException e) {

					e.printStackTrace();
				}
				break;

			case 3:
				app.getAllCanceledOrder();
				break;

			case 4:
				app.createOrderMapByUser();
				break;

			case 5:
				app.filterOrders(null);
				break;

			case 6:
				app.getOrdersBasedOnOrderValue();
				break;

			case 7:
				app.generatePDFReports();
				break;

			default:
				break;
			}
		}
	}

	@Override
	public List<Order> getAllOrdersByCategory(String category) throws InvalidCategryException {

		List<Order> orderCategory = new ArrayList<Order>();
		try {
			String rootPath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite\\CaseStudy_CoreJava\\";
			String fileName = "Order.csv";
			File f = new File(rootPath + fileName);

			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");

				System.out.println("Category : " + values[1]);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return orderCategory;
	}

	@Override
	public int getTotalOrderCost(String category) throws InvalidCategryException {

		int[] totalOrder = new int[5];

		try {

			String rootPath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite\\CaseStudy_CoreJava\\";
			String fileName = "Order.csv";
			File f = new File(rootPath + fileName);

			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				for (int i = 0; i < values.length; i++) {
					totalOrder[i] += Integer.parseInt(values[2]);
				}

				System.out.println("\n ---Total Order Costs---" + Arrays.toString(totalOrder));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}

	@Override
	public List<Order> getAllCanceledOrder() {

		List<Order> canceledOrder = new ArrayList<>();

		try {
			String rootPath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite\\CaseStudy_CoreJava\\";
			String fileName = "Order.csv";
			File f = new File(rootPath + fileName);

			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				Order order = new Order();
				String action = values[4];

				if (action.equals("delivered")) {
					order.setAction(true);
				} else {
					order.setAction(false);
					System.out.println("username: " + values[0] + ", " + "Action: " + values[4]);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return canceledOrder;
	}

	@Override
	public Map<String, List<Order>> createOrderMapByUser() {

		HashMap<String, List<Order>> orderMap = new HashMap<>();

		List<Order> order = new ArrayList<>();

		try {
			String rootPath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite\\CaseStudy_CoreJava\\";
			String fileName = "Order.csv";
			File f = new File(rootPath + fileName);

			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			br.readLine();

			while ((line = br.readLine()) != null) {

				// System.out.println(line);
				String[] values = line.split(",");

				try {

					// key
					String username = String.valueOf(values[0]);

					if (!orderMap.containsKey(username))

					{
						orderMap.put(username, order);

					}

				} catch (NumberFormatException e) {
					System.out.println("NumberFormatException occurred");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

		System.out.println("\n =======Order Map=====");
		System.out.println(orderMap);

		return orderMap;

	}

	@Override
	public List<Order> filterOrders(String action) {

		List<Order> filterOrder = new ArrayList<Order>();

		try {
			String rootPath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite\\CaseStudy_CoreJava\\";
			String fileName = "Order.csv";
			File f = new File(rootPath + fileName);

			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");

				Order order = new Order();
				String a = values[4];

				if (a.equals("delivered")) {
					order.setAction(true);
					System.out.println("username: " + values[0] + ", " + "Action: " + values[4]);
				} else {
					order.setAction(false);

				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return filterOrder;

	}

	@Override
	public List<Order> getOrdersBasedOnOrderValue() {

		List<Order> orderValue = new ArrayList<>();

		try {
			String rootPath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite\\CaseStudy_CoreJava\\";
			String fileName = "Order.csv";
			File f = new File(rootPath + fileName);

			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");

				Order orderObj = new Order();
				orderObj.setUsername(values[0]);
				orderObj.setCategory(values[1]);
				orderObj.setOrderCost(Integer.parseInt(values[2]));
				// orderObj.setDate(LocalDate.parse(values[3]));
				orderObj.setAction(Boolean.parseBoolean(values[4]));

//				DateTimeFormatter date = new DateTimeFormatterBuilder()
//						// case insensitive to parse JAN and FEB
//					    .parseCaseInsensitive()
//					    // add pattern
//					    .appendPattern("d-MMM-yy")
//					    // create formatter (use English Locale to parse month names)
//					    .toFormatter(Locale.ENGLISH);
//				

				// System.out.println(values[2]);

				orderValue.add(orderObj);

				SortOrderBasedOnValue sortValue = new SortOrderBasedOnValue();
				Collections.sort(orderValue, sortValue);

				print(orderValue, "Sort based on Value");

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return orderValue;

	}

	@Override
	public boolean generatePDFReports() {

		String rootPath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite\\CaseStudy_CoreJava\\";
		String fileName = "Report.pdf";

		File f = new File(rootPath + fileName);
		PDDocument myPdf = new PDDocument();

		try {
			PDPage page = new PDPage();
			myPdf.addPage(page);

			PDPageContentStream orders = new PDPageContentStream(myPdf, page);

			orders.beginText();
			orders.endText();
			orders.close();

			myPdf.save("Report.pdf");
			System.out.println("Report created");
			myPdf.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	public static void print(Collection<Order> collection, String tagLine) {
		System.out.println("\n-----" + tagLine + " -----\n");

		for (Order order : collection) {
			System.out.println(order);

		}
	}

	public static List<Order> fileRead() throws IOException {
		List<Order> orderList = new ArrayList<>();

		try {
			String rootPath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite\\CaseStudy_CoreJava\\";
			String fileName = "Order.csv";
			File f = new File(rootPath + fileName);

			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			br.readLine();

			while ((line = br.readLine()) != null) {

				System.out.println(line);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return orderList;

	}

}// end of main
