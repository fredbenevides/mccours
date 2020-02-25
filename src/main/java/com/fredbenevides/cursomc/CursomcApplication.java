package com.fredbenevides.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fredbenevides.cursomc.domain.Address;
import com.fredbenevides.cursomc.domain.Category;
import com.fredbenevides.cursomc.domain.City;
import com.fredbenevides.cursomc.domain.Customer;
import com.fredbenevides.cursomc.domain.Payment;
import com.fredbenevides.cursomc.domain.PaymentCreditCard;
import com.fredbenevides.cursomc.domain.PaymentFactured;
import com.fredbenevides.cursomc.domain.Product;
import com.fredbenevides.cursomc.domain.Purchase;
import com.fredbenevides.cursomc.domain.PurchasedItem;
import com.fredbenevides.cursomc.domain.State;
import com.fredbenevides.cursomc.domain.enums.CustomerType;
import com.fredbenevides.cursomc.domain.enums.PaymentStatus;
import com.fredbenevides.cursomc.repositories.AddressRepository;
import com.fredbenevides.cursomc.repositories.CategoryRepository;
import com.fredbenevides.cursomc.repositories.CityRepository;
import com.fredbenevides.cursomc.repositories.CustomerRepository;
import com.fredbenevides.cursomc.repositories.PaymentRepository;
import com.fredbenevides.cursomc.repositories.ProductRepository;
import com.fredbenevides.cursomc.repositories.PurchaseRepository;
import com.fredbenevides.cursomc.repositories.PurchasedItemRepository;
import com.fredbenevides.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PurchasedItemRepository purchasedItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Info");
		Category cat2 = new Category(null, "Escritorio");

		Product p1 = new Product(null, "Ordinateur", 2000.00);
		Product p2 = new Product(null, "Imprimante", 800.00);
		Product p3 = new Product(null, "Sourris", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		State s1 = new State(null, "Quebec");
		State s2 = new State(null, "Ontario");

		City c1 = new City(null, "Montreal", s1);
		City c2 = new City(null, "Trois Rivieres", s1);
		City c3 = new City(null, "Otawa", s2);

		s1.getCities().addAll(Arrays.asList(c1, c2));
		s2.getCities().addAll(Arrays.asList(c3));

		stateRepository.saveAll(Arrays.asList(s1, s2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Customer cli1 = new Customer(null, "Maria Silva", "maria@gmail.com", "02200933428", CustomerType.NATURALPERSON);
		cli1.getPhones().addAll(Arrays.asList("32316825", "34342081"));

		Address a1 = new Address(null, "5314", "Av Louis Joseph Doucet", null, null, "H1M3J9", cli1, c1);
		Address a2 = new Address(null, "304", "Rua da Baixa Verde", "apto 701", "Derby", "52010-250", cli1, c2);

		cli1.getAddresses().addAll(Arrays.asList(a1, a2));

		customerRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Purchase pur1 = new Purchase(null, sdf.parse("30/09/2017 10:32"), cli1, a1);
		Purchase pur2 = new Purchase(null, sdf.parse("10/10/2017 19:35"), cli1, a2);
		
		Payment pg1 = new PaymentCreditCard(null, PaymentStatus.PAID, pur1, 6);
		pur1.setPayment(pg1);
		
		Payment pg2 = new PaymentFactured(null, PaymentStatus.PENDING, pur2, sdf.parse("20/10/2017 00:00"), null);
		pur2.setPayment(pg2);
		
		cli1.getPurchases().addAll((Arrays.asList(pur1, pur2)));
		
		purchaseRepository.saveAll(Arrays.asList(pur1, pur2));
		paymentRepository.saveAll(Arrays.asList(pg1, pg2));
		
		PurchasedItem pi1 = new PurchasedItem(pur1, p1, 0.00, 2000.00, 1);
		PurchasedItem pi2 = new PurchasedItem(pur1, p3, 0.00, 80.00, 2);
		PurchasedItem pi3 = new PurchasedItem(pur2, p2, 100.00, 800.00, 1);
		
		pur1.getItems().addAll(Arrays.asList(pi1, pi2));
		pur2.getItems().addAll(Arrays.asList(pi3));
		
		p1.getItems().addAll(Arrays.asList(pi1));
		p2.getItems().addAll(Arrays.asList(pi3));
		p3.getItems().addAll(Arrays.asList(pi2));
		
		purchasedItemRepository.saveAll(Arrays.asList(pi1, pi2, pi3));
		
		
	}
}