package zoopark.model;

import java.sql.SQLException;
import java.util.ArrayList;


public class ModelTest {

	public static void main(String[] args) {
		ParkModelDM model = new ParkModelDM();
		ArrayList<Park> beanCollection;
		try {
			 beanCollection = (ArrayList<Park>) model.doRetrieveAll("");
			 if(beanCollection==null)
				 System.out.println();
			 else {
				 System.out.println(beanCollection);
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
