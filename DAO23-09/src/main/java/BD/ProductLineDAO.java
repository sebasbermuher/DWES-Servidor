package BD;

import java.util.List;

public interface ProductLineDAO {
	
	ProductLine getProductLine(String name);
	List<ProductLine>getProductLine();
	void deleteProductLine(String name);
	
	

}
