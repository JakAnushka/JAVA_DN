import java.util.Arrays;
import java.util.Comparator;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}

class SearchUtility {

    // Linear Search by product name
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search by product name
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    // sort products by name
    public static void sortProductsByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
    }
}

// main class
public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Shoes", "Footwear"),
                new Product(102, "T-Shirt", "Clothing"),
                new Product(103, "Laptop", "Electronics"),
                new Product(104, "Backpack", "Accessories"),
                new Product(105, "Watch", "Accessories")
        };

        // Linear Search Test
        Product foundLinear = SearchUtility.linearSearch(products, "Laptop");
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        // Sorting array by name
        SearchUtility.sortProductsByName(products);

        // Binary Search Test
        Product foundBinary = SearchUtility.binarySearch(products, "Laptop");
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}