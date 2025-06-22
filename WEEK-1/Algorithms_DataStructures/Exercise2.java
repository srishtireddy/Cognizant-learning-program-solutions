/*E-commerce Platform Search Function
This code compares between linear search and binary search for finding products in an e-commerce platform and also displays the time taken for each search method.
What is Big O Notation, and Why Does It Matter?
Big O shows how algorithm speed changes as data grows. It ignores actual timing and focuses on growth patterns.
O(n) grows linearly with data; O(log n) grows slower, making it efficient for large data.
Best, Average, and Worst-Case Scenarios in Searching
Linear search: Best case O(1), average/worst case O(n).
Binary search (sorted list): Best case O(1), average/worst case O(log n).
*/
import java.util.Arrays;
import java.util.Comparator;

public class  Exercise2 {
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }
    }
    static class SearchService {
        public static Product linearSearch(Product[] products, String targetName) {
            for (Product product : products) {
                if (product.productName.equalsIgnoreCase(targetName)) {
                    return product;
                }
            }
            return null;
        }
        public static Product binarySearch(Product[] products, String targetName) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int cmp = products[mid].productName.compareToIgnoreCase(targetName);

                if (cmp == 0) return products[mid];
                else if (cmp < 0) left = mid + 1;
                else right = mid - 1;
            }

            return null;
        }
    }
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Shoes", "Footwear"),
            new Product(105, "Mouse", "Accessories")
        };

        String target = "Phone";

        // Linear Search
        long start1 = System.nanoTime();
        Product res1 = SearchService.linearSearch(products, target);
        long end1 = System.nanoTime();
        System.out.println("Linear Search: " + (res1 != null));
        System.out.println("Time: " + (end1 - start1) + " ns");

        // Sort before Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search
        long start2 = System.nanoTime();
        Product res2 = SearchService.binarySearch(products, target);
        long end2 = System.nanoTime();
        System.out.println("Binary Search: " + (res2 != null));
        System.out.println("Time: " + (end2 - start2) + " ns");
    }
}
/*
Output: Linear Search: true
Time: 1026700 ns
Binary Search: true
Time: 12500 ns
 */