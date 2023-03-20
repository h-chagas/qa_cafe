package qa_cafe;

import static org.junit.Assert.*;
import org.junit.Test;

public class QACafe_test {

	@Test
	public void testTableIsCreated() {
		boolean allGood = true;
		boolean actual = Create.proceed(allGood);
		boolean expected = false;
		assertNotEquals(expected, actual);
	}
	
//	@Test
//	public void testAddingCustomer() {
//		boolean addCustomerWorked = true;
//		boolean actual = AddCustomer.proceed(addCustomerWorked);
//		boolean expected = false;
//		assertNotEquals(expected, actual);
//	}
	
//	@Test
//	public void testReadingAllOrders() {
//		boolean readAllWorked = true;
//		boolean actual = ReadAllOrders.proceed(readAllWorked);
//		boolean expected = false;
//		assertNotEquals(expected, actual);
//	}
	
//	@Test
//	public void testUpdatingOrder() {
//		boolean addUpdatingWorked = true;
//		boolean actual = Update.proceed(addUpdatingWorked);
//		boolean expected = false;
//		assertNotEquals(expected, actual);
//	}
	
//	@Test
//	public void deletingAllOrders() {
//		boolean deleteAllWorked = true;
//		boolean actual = DeleteAllOrders.proceed(deleteAllWorked);
//		boolean expected = false;
//		assertNotEquals(expected, actual);
//	}
	

}
