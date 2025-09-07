Đúng vậy, một trong những mục đích chính của việc sử dụng **Wrapper Classes** để chuyển đổi kiểu dữ liệu nguyên thủy (primitive types) thành đối tượng trong Java là để phục vụ cho **Collections Framework** (như `ArrayList`, `HashMap`, `HashSet`, v.v.). Dưới đây là lý do chi tiết và các mục đích khác của việc chuyển đổi này:

### 1. **Hỗ trợ Collections Framework**
- **Collections chỉ làm việc với đối tượng**: Trong Java, các lớp trong Collections Framework (như `ArrayList`, `HashMap`, `HashSet`, v.v.) không thể lưu trữ trực tiếp các kiểu dữ liệu nguyên thủy (`int`, `double`, `char`, v.v.). Chúng chỉ chấp nhận các đối tượng. Do đó, Wrapper Classes (`Integer`, `Double`, `Character`, v.v.) được sử dụng để "bao bọc" các kiểu nguyên thủy thành đối tượng.
- **Ví dụ**:
  ```java
  ArrayList<Integer> numbers = new ArrayList<>();
  numbers.add(10); // Autoboxing: int -> Integer
  numbers.add(20);
  System.out.println(numbers); // Kết quả: [10, 20]
  ```
  Ở đây, giá trị `int` được tự động chuyển thành `Integer` (autoboxing) để có thể thêm vào `ArrayList`.

- **Generics yêu cầu đối tượng**: Generics trong Java (như `List<T>`) chỉ hoạt động với các kiểu đối tượng, không chấp nhận kiểu nguyên thủy. Vì vậy, cần sử dụng `List<Integer>` thay vì `List<int>`.

### 2. **Các mục đích khác của việc chuyển đổi**
Ngoài việc phục vụ Collections, Wrapper Classes còn có các mục đích khác:
- **Cung cấp phương thức tiện ích**: Wrapper Classes đi kèm với các phương thức hữu ích để xử lý dữ liệu, như chuyển đổi chuỗi thành số (`Integer.parseInt()`), lấy giá trị min/max (`Integer.MAX_VALUE`), hoặc so sánh giá trị (`compareTo()`).
  ```java
  String str = "123";
  int number = Integer.parseInt(str); // Chuyển chuỗi thành int
  System.out.println("Max Integer: " + Integer.MAX_VALUE);
  ```
- **Hỗ trợ giá trị `null`**: Kiểu nguyên thủy không thể có giá trị `null`, nhưng Wrapper Classes có thể. Điều này hữu ích trong các trường hợp cần biểu diễn trạng thái "không có giá trị" (ví dụ: trong cơ sở dữ liệu hoặc API).
  ```java
  Integer number = null; // Hợp lệ
  // int primitive = null; // Lỗi biên dịch
  ```
- **Tích hợp với các API yêu cầu đối tượng**: Nhiều API trong Java (như JDBC, Hibernate, hoặc các thư viện xử lý JSON) yêu cầu dữ liệu dưới dạng đối tượng thay vì kiểu nguyên thủy.
- **Hỗ trợ lập trình hướng đối tượng**: Wrapper Classes cho phép sử dụng kiểu nguyên thủy trong các ngữ cảnh cần tính chất của đối tượng, như kế thừa, đa hình, hoặc truyền tham chiếu.

### 3. **Hạn chế và lưu ý**
- **Hiệu suất**: Wrapper Classes sử dụng nhiều bộ nhớ hơn và chậm hơn so với kiểu nguyên thủy vì chúng là đối tượng.
- **NullPointerException**: Khi unboxing một Wrapper Class có giá trị `null`, có thể xảy ra lỗi.
  ```java
  Integer number = null;
  int value = number; // Gây ra NullPointerException
  ```
- **Autoboxing/Unboxing tự động**: Java tự động xử lý việc chuyển đổi (từ Java 5), nhưng cần cẩn thận để tránh lỗi hoặc giảm hiệu suất khi sử dụng trong vòng lặp lớn.

### Kết luận
Mục đích chính của việc chuyển kiểu nguyên thủy sang Wrapper Classes là để sử dụng trong **Collections Framework**, nơi yêu cầu dữ liệu phải là đối tượng. Ngoài ra, Wrapper Classes còn cung cấp các tính năng bổ sung như phương thức tiện ích, hỗ trợ `null`, và tương thích với các API hoặc lập trình hướng đối tượng. Tuy nhiên, cần sử dụng cẩn thận để tránh các vấn đề về hiệu suất hoặc lỗi runtime.